package com.sbnri.pawankumarsbnri.viewmodel

import android.preference.PreferenceManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sbnri.pawankumarsbnri.network.ApiClient
import com.sbnri.pawankumarsbnri.network.ApiList
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.io.EOFException
import java.net.ProtocolException
import java.net.UnknownHostException
import java.net.UnknownServiceException

abstract class BaseViewModel : ViewModel() {
   var postApi : ApiList = ApiClient.getApis()
    lateinit var subsription : Disposable

    val loadingBar : MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage : MutableLiveData<String> = MutableLiveData()

    protected fun onApiCallStart(){
        loadingBar.value = true
    }
    protected fun onApiCallFinish(){
        loadingBar.value = false
    }

     fun onApiCallError(cause: Throwable?) : String{
        if(cause!=null) {
            if (cause is HttpException) {
                return when (cause.code()) {
                    400 -> "Bad Request"
                    401 -> "Token Expired"
                    403 -> "Request refused to the server"
                    404 -> "File not found"
                    500 -> "Internal Server Error"
                    502 -> "Server got an invalid response"
                    503 -> "The server is not ready to handle the request"
                    else -> {
                        cause.message()
                    }
                }
            }
            else if (cause is EOFException){
                return "End Of File Exception"
            }else if (cause is UnknownServiceException){
                return "Unknown Service Exception"
            }else if (cause is UnknownHostException){
                return "No Internet Connection"
            }else if (cause is ProtocolException){
                return "ProtocolException"
            }else{
                return cause.toString()
            }
        }
        return cause.toString()
    }
}