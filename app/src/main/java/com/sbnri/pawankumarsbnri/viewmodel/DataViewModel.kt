package com.sbnri.pawankumarsbnri.viewmodel

import android.os.AsyncTask
import android.util.Log
import com.sbnri.pawankumarsbnri.AppConstants
import com.sbnri.pawankumarsbnri.HttpHandler
import com.sbnri.pawankumarsbnri.adapter.DataAdapter
import org.json.JSONArray

class DataViewModel : BaseViewModel() {
    var dataAdapter = DataAdapter()
    init {
        GetDetails().execute()
    }

    private inner class GetDetails : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()

        }

        override fun doInBackground(vararg arg0: Void?): String? {
            val sh = HttpHandler()
            // Making a request to url and getting response
            val jsonStr = sh.makeServiceCall(AppConstants.URL)
            try {
                val jArray = JSONArray(jsonStr.toString())
                // Extract data from json and store into ArrayList as class objects
                for (i in 0 until jArray.length()) {
                    val json_data = jArray.getJSONObject(i)
                }
            }
            catch (e: Exception){
                Log.d("TAG", "Exception " + e.toString())
            }
            return null
        }
    }

}