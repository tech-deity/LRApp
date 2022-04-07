package com.example.lrapp.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.internal.tls.OkHostnameVerifier
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val BASE_URL="https://gwebapi.000webhostapp.com/"

    private val gson:Gson by lazy{
        GsonBuilder().setLenient().create()
    }
    private val httpClient:OkHttpClient by lazy{
        OkHttpClient.Builder().build()
    }
    fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}