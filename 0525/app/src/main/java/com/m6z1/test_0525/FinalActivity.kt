package com.m6z1.test_0525

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import com.m6z1.test_0525.databinding.ActivityFinalBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultView = binding.textview

        // 이전 액티비티로부터 전달받은 값 가져오기
        val radioValue = intent.getStringExtra(SecondActivity.RADIO_BUTTON_VALUE_KEY)
        val busIdValue = intent.getStringExtra(ThirdActivity.BUS_ID_VALUE_KEY)
        val messageValue = intent.getStringExtra(ThirdActivity.MESSAGE_VALUE_KEY)

        // JSON 객체 생성
        val jsonData = JsonObject()
        jsonData.addProperty("id",radioValue)
        jsonData.addProperty("busStopId",busIdValue)
        jsonData.addProperty("message",messageValue)


        // POST 요청 보내기
        Retrofit.service.sendRideBellData(jsonData).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    // 요청 성공
                    val responseData = response.body()?.string()
                    resultView.text = responseData
                } else {
                    resultView.text = "요청 실패"
                    response.errorBody()?.string()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("log", t.message.toString())
            }
        })
    }
}
