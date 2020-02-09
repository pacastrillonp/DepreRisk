package com.example.deprerisk.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.deprerisk.SendDataService
import com.example.deprerisk.persistence.QuestionRepository
import com.example.deprerisk.persistence.room.BeckInventoryDataBase
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity


class DepressionRiskViewModel(application: Application) : AndroidViewModel(application) {

    private val questionRepository: QuestionRepository

    val allQuestions : LiveData<List<BeckInventoryEntity>>

    init {
        val beckInventoryDao = BeckInventoryDataBase.getDatabase(application,viewModelScope).beckInventoryDao()
        questionRepository = QuestionRepository(beckInventoryDao)
        allQuestions = questionRepository.allQuestions
    }


//    fun getAllQuestions(): LiveData<List<BeckInventoryEntity>> {
//        return questionRepository.getAllQuestions()
//    }

    fun getQuestions(id: Int): LiveData<BeckInventoryEntity> {
        return questionRepository.getQuestion(id)
    }

    private fun sendMessage() {
        val message = ""
        Log.d("message", message)
        SendDataService().execute(message)
    }
}