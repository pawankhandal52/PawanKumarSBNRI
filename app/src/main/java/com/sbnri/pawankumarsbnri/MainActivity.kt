package com.sbnri.pawankumarsbnri

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sbnri.pawankumarsbnri.viewmodel.DataViewModel
import com.sbnri.pawankumarsbnri.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName
    private lateinit var viewModel : DataViewModel

    override fun layoutRes(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = viewModel
    }

}
