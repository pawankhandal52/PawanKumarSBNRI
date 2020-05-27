package com.sbnri.pawankumarsbnri

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sbnri.pawankumarsbnri.viewmodel.DataViewModel
import com.sbnri.pawankumarsbnri.databinding.ActivityMainBinding
import com.sbnri.pawankumarsbnri.model.DataResponse

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var viewModel : DataViewModel

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel


        viewModel.loadingBar.observe(this, Observer {

            if(it){
                progressBar.show()
            }else{
                progressBar.dismiss()
            }
        })
        viewModel.noDataFound.observe(this, Observer {

            if(it){
                mBinding.noDataFound.visibility = View.VISIBLE
            }else{
                mBinding.noDataFound.visibility = View.GONE
            }
        })
        viewModel.errorMessage.observe(this, Observer {
        Toast.makeText(this,it,Toast.LENGTH_LONG).show()

        })
        viewModel.localData.observe(this, Observer {
            t: List<DataResponse> ->
            if(t.isNullOrEmpty()){
                viewModel.noDataFound.value = true
            }
            viewModel.dataAdapter.submitList(t)


        })

        setupScrollListener()



    }

    private fun setupScrollListener() {
        val layoutManager = mBinding.rvDetail.layoutManager as androidx.recyclerview.widget.LinearLayoutManager
        mBinding.rvDetail.addOnScrollListener(object : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                viewModel.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)
            }
        })
    }



}
