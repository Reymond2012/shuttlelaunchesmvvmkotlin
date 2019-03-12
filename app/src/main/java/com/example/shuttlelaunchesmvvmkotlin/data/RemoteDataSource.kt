package com.example.shuttlelaunchesmvvmkotlin.data

import android.os.Build.VERSION_CODES.BASE
import com.example.shuttlelaunchesmvvmkotlin.net.BASE_URL
import com.example.shuttlelaunchesmvvmkotlin.net.HaveIBeenPawnedService
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource: DataSource {

    private val haveIBeenPawnedService: HaveIBeenPawnedService by lazy {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
        retrofit.create(HaveIBeenPawnedService::class.java)

    }


    override fun getListOfBreaches(domainName: String)
            =  haveIBeenPawnedService.getListOfBreaches(domainName)
}