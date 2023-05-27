package com.m6z1.test_0525

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.m6z1.test_0525.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btn = binding.btnNext

        btn.setOnClickListener {
            val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                // 선택된 라디오 버튼의 값을 가져오기
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedRadioButtonValue = selectedRadioButton.text.toString()

                // 데이터를 Intent에 저장하여 다음 화면으로 전달
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra(RADIO_BUTTON_VALUE_KEY, selectedRadioButtonValue)
                startActivity(intent)
            } else {
                // 예외처리를 하는 습관을 들이자
            }
        }

        /*
            var selectedValue: String? = null

            binding.radioGroup.setOnCheckedChangeListener { radioGroup, i ->
                val selectedRadioButton = radioGroup.getChildAt(i) as RadioButton
                selectedValue = selectedRadioButton.text.toString()
            }

            btn.setOnClickListener {
                if(selectedValue != null) {
                    val intent = Intent(this, ThirdActivity::class.java)
                    intent.putExtra(RADIO_BUTTON_VALUE_KEY, selectedValue)
                    startActivity(intent)
                }
            }

        */
    }

    companion object {
        // GOOD
        const val RADIO_BUTTON_VALUE_KEY = "radioButtonValue"
    }
}