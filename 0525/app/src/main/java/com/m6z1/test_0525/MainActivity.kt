package com.m6z1.test_0525

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m6z1.test_0525.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}

// dp, sp 차이
// companion object
// object
// lambda function (lambda object)
// constraint layout chaining, 0dp
// 직렬화, 역직렬화
// Data class 의 copy (deep copy)
// binding 쓸 때 View 를 변수로 선언하지 말 것