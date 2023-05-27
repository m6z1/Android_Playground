package com.m6z1.test_0525

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val URL = "http://52.3.106.119:8080/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: RetrofitService =
        retrofit.create(RetrofitService::class.java)
}