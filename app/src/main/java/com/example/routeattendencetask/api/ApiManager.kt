package com.example.routeattendencetask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
    private val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getListServices(): ListServices {
        return retrofit.create(ListServices::class.java)
    }
}