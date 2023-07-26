package com.m6z1.imagetoserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.m6z1.imagetoserver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {

        }
    }
}