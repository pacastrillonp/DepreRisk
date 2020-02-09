package com.example.deprerisk

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.deprerisk.viewmodel.DepressionRiskViewModel

class DepressionRiskActivity : AppCompatActivity() {
    private lateinit var viewModel: DepressionRiskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        viewModel = ViewModelProvider(this).get(DepressionRiskViewModel::class.java)

//        button.setOnClickListener { sendMessage() }
    }
}
