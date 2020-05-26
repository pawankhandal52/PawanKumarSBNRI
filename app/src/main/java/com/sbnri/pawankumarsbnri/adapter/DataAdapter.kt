package com.sbnri.pawankumarsbnri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sbnri.pawankumarsbnri.BR
import com.sbnri.pawankumarsbnri.R
import com.sbnri.pawankumarsbnri.databinding.ItemDataListBinding
import com.sbnri.pawankumarsbnri.model.DataResponse

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>(){

    private  var dataList: MutableList<DataResponse> = ArrayList<DataResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<ItemDataListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_data_list,parent,false)
        return DataViewHolder(binding)
    }

    override fun getItemCount()= dataList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataList = dataList[position]
        holder.bind(dataList)
    }

    fun clear(){
        dataList.clear()
        notifyDataSetChanged()
    }

    internal fun setData(_dataItem: String?) {
        //this.dataList = _dataItem
        //notifyDataSetChanged()
    }

    inner class DataViewHolder(var itemRowBinding : ItemDataListBinding): RecyclerView.ViewHolder(itemRowBinding.root){
        fun bind(dataList: DataResponse){
            itemRowBinding.setVariable(BR.model,dataList)
            itemRowBinding.executePendingBindings()
        }
    }
}