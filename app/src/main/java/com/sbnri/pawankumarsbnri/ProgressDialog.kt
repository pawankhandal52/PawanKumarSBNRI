/*
 * *
 *  * Created by Pawan Kumar Sharma on 10/23/19 10:33 AM
 *  * Copyright (c) Fleeca India Pvt Ltd 2019 . All rights reserved.
 *  * Last modified 10/22/19 5:23 PM
 *  * Developer Email:-pawan@fleeca.in
 *  * Mobile No:- +917737947610
 *
 */

package com.sbnri.pawankumarsbnri

import android.app.Dialog
import android.content.Context
import android.os.Bundle

class ProgressDialog(context: Context): Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)
        setCancelable(false)
        setCanceledOnTouchOutside(false)

    }
}