package com.sbnri.pawankumarsbnri

import android.os.Bundle
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    open lateinit var mBinding : T
    lateinit var progressBar: ProgressBar

    @LayoutRes
    abstract fun layoutRes() : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,layoutRes())
        progressBar = ProgressBar(this,null, R.attr.progressBarStyle)
    }

     override fun onBackPressed() {
         super.onBackPressed()
         finish()
     }

}