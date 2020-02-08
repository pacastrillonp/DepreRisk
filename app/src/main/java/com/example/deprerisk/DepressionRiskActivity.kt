package com.example.deprerisk

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class DepressionRiskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
//        button.setOnClickListener { sendMessage() }
    }

    private fun sendMessage() {
//        val message = editText.text.toString()
        val message = ""
        Log.d("message", message)
        SendDataService().execute(message)
    }
}
