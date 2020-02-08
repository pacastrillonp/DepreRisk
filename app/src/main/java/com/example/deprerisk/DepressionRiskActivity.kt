package com.example.deprerisk

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.deprerisk.persistence.QuestionRepository
import com.example.deprerisk.persistence.room.BeckInventoryDataBase

class DepressionRiskActivity : AppCompatActivity() {
    private lateinit var beckInventoryDataBase: BeckInventoryDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        beckInventoryDataBase = BeckInventoryDataBase.getDatabase(this)
        val questionRepository = QuestionRepository(beckInventoryDataBase.beckInventoryDao())
        questionRepository.insertToDB()
//        button.setOnClickListener { sendMessage() }
    }

    private fun sendMessage() {
//        val message = editText.text.toString()
        val message = ""
        Log.d("message", message)
        SendDataService().execute(message)
    }
}
