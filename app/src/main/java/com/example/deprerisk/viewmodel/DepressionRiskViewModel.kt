package com.example.deprerisk.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.deprerisk.SendDataService
import com.example.deprerisk.persistence.QuestionRepository
import com.example.deprerisk.persistence.room.BeckInventoryDataBase

class DepressionRiskViewModel() : ViewModel() {
//    private var beckInventoryDataBase = BeckInventoryDataBase.getDatabase(context)

    init {
//        val questionRepository = QuestionRepository(beckInventoryDataBase.beckInventoryDao())
//        questionRepository.insertToDB()

    }


    private fun sendMessage() {
//        val message = editText.text.toString()
        val message = ""
        Log.d("message", message)
        SendDataService().execute(message)
    }
}