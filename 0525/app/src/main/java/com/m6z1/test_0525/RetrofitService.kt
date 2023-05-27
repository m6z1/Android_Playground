package com.m6z1.test_0525

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {
    @POST("/RideBell")
    fun sendRideBellData(@Body jsonData: JsonObject): Call<ResponseBody>
}