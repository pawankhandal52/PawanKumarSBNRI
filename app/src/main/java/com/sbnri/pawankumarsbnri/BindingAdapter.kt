package com.sbnri.pawankumarsbnri

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sbnri.pawankumarsbnri.model.Permissions

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>){
    view.adapter = adapter
}
@BindingAdapter("permission")
fun setPermission(view: TextView,data: Permissions?){
    var permission:String = ""
    permission += if(data?.admin!!){
        "Permission:- Admin: Yes, "
    }else{
        "Permission:- Admin: No, "

    }
    permission += if(data.pull!!){
        "Pull: Yes, "
    }else{
        "Pull: No, "

    }
    permission += if(data.push!!){
        "Push: Yes"
    }else{
        "Push: No"
    }
    view.text = permission
}