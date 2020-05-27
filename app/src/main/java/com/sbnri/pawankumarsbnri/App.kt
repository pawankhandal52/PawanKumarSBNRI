package com.sbnri.pawankumarsbnri

import android.app.Application
import android.content.Context
import io.realm.Realm

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        mContext = this
    }

    companion object {
        lateinit var mContext: Context
    }
}