package com.example.routeattendencetask.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ListServices {

    @GET("products")
    fun getList(

    ): Call<ListResponse>
}