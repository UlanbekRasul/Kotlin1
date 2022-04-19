package com.geektech.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.kotlin1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val KEY_BACK = "keyBack"
        const val KEY1 = "key1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etValue.setText(intent.getStringExtra(KEY1))
        binding.btnBack.setOnClickListener {
            setResult(RESULT_OK, Intent().putExtra(KEY_BACK, binding.etValue.text.toString()))
            finish()
        }
    }
}