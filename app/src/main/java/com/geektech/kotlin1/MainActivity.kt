package com.geektech.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geektech.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    companion object {
        const val KEY1 = "key1"
        const val KEY_BACK = "keyBack"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.btnIntent.setOnClickListener {
            if (viewBinding.etText.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.warning),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra(KEY1, viewBinding.etText.text.toString())
                    registerForActivityResult.launch(this)
                }
            }
        }
        registerForActivityResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            viewBinding.etText.setText(result.data?.getStringExtra(KEY_BACK))
        }

    }
}