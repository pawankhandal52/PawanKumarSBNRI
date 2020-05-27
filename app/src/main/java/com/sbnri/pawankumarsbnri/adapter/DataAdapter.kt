package com.sbnri.pawankumarsbnri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sbnri.pawankumarsbnri.R
import com.sbnri.pawankumarsbnri.databinding.ItemDataListBinding
import com.sbnri.pawankumarsbnri.model.DataResponse

class DataAdapter : ListAdapter<DataResponse, DataAdapter.DataViewHolder>(REPO_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataBindingUtil.inflate<ItemDataListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_data_list,parent,false)
        return DataViewHolder(binding)
    }



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }




    inner class DataViewHolder(var itemRowBinding : ItemDataListBinding): RecyclerView.ViewHolder(itemRowBinding.root){
        fun bind(dataList: DataResponse){
            itemRowBinding.itemdata = dataList
        }
    }


    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<DataResponse>() {
            override fun areItemsTheSame(oldItem: DataResponse, newItem: DataResponse): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: DataResponse, newItem: DataResponse): Boolean =
                oldItem == newItem
        }
    }
}