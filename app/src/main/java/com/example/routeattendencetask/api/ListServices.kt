package com.example.routeattendencetask.api

import retrofit2.Call
import retrofit2.http.GET

interface ListServices {

    @GET("products")
    fun getList(): Call<ListResponse>
}