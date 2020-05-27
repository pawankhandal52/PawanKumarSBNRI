package com.sbnri.pawankumarsbnri

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    open lateinit var mBinding : T
    lateinit var progressBar: ProgressDialog

    @LayoutRes
    abstract fun layoutRes() : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,layoutRes())
        progressBar = ProgressDialog(this)

    }

     override fun onBackPressed() {
         super.onBackPressed()
         finish()
     }

}