package com.timi.seulseul

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val key = URLEncoder.encode("PGInz0mT7cB3lNR6dubEe1et2oHbV01qZ9tND6PLH7c", "UTF-8")

        // connect(key)

        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient
            .Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.odsay.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(TimTImService::class.java)

        api.getTimTim(key).enqueue(object : Callback<Example> {
            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                Toast.makeText(this@MainActivity, "Test ON", Toast.LENGTH_LONG).show()
                if (response.isSuccessful) {
                    Log.w("example", "result : ${response.body()?.result}")
                }
            }

            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Test OFF", Toast.LENGTH_LONG).show()
                Log.e("example", "Error : ${t.message}")
            }
        })
    }

    fun connect(key: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val apiKey = key

            val urlInfo = ("https://api.odsay.com/v1/api/searchBusLane?busNo=10&CID=1000&apiKey="
                    + URLEncoder.encode(apiKey, "UTF-8"))

            // http 연결

            // http 연결
            val url = URL(urlInfo)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-type", "application/json")

            val bufferedReader = BufferedReader(InputStreamReader(conn.inputStream))

            val sb = StringBuilder()
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                sb.append(line)
            }

            Log.w("Test Result", "$sb")

            bufferedReader.close()
            conn.disconnect()
        }

    }
}