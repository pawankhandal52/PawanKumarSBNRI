package com.sbnri.pawankumarsbnri.network

import com.google.gson.GsonBuilder
import com.sbnri.pawankumarsbnri.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private var retrofit: Retrofit? = null
    private var apiList: ApiList? = null

    fun getApis(): ApiList {
        if (retrofit == null) {
            setUpClient()
        }
        return retrofit!!.create(ApiList::class.java)
    }



    private fun setUpClient() {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded").build()
            chain.proceed(request)
        }

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            //httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        }
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(interceptor)
            .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()
        retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.ROOT)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        apiList = retrofit!!.create(ApiList::class.java)

    }



}
