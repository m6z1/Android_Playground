package com.timi.seulseul

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TimTImService {

    @GET("/v1/api/searchBusLane?busNo=10&CID=1000")
    fun getTimTim(
        @Query("apiKey") apiKey: String
    ): Call<Example>
}

