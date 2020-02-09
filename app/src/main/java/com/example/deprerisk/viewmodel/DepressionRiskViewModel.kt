package com.example.deprerisk.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.deprerisk.SendDataService
import com.example.deprerisk.persistence.QuestionRepository
import com.example.deprerisk.persistence.room.BeckInventoryDataBase
import java.util.concurrent.Callable
import java.util.concurrent.Executors

class DepressionRiskViewModel() : ViewModel() {

    fun insertData(context: Context) {
        val callable = Callable {
            val beckInventoryDataBase = BeckInventoryDataBase.getDatabase(context)
            val questionRepository = QuestionRepository(beckInventoryDataBase.beckInventoryDao())
            questionRepository.insertToDB()
        }
        Executors.newSingleThreadExecutor().submit(callable)
    }

    private fun sendMessage() {
//        val message = editText.text.toString()
        val message = ""
        Log.d("message", message)
        SendDataService().execute(message)
    }
}