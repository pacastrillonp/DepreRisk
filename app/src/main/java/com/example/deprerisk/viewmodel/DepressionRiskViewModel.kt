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
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity
import com.google.gson.Gson


class DepressionRiskViewModel(application: Application) : AndroidViewModel(application) {

    private val questionRepository: QuestionRepository

    val allQuestions: LiveData<List<BeckInventoryEntity>>

    init {
        val beckInventoryDao =
            BeckInventoryDataBase.getDatabase(application, viewModelScope).beckInventoryDao()
        val questionnaireAnswersDao =
            BeckInventoryDataBase.getDatabase(application, viewModelScope).questionnaireAnswersDao()
        questionRepository = QuestionRepository(beckInventoryDao, questionnaireAnswersDao)
        allQuestions = questionRepository.allQuestions
    }

    fun saveAnswer(answerId: Int, answer: String) {
        questionRepository.saveAnswer(answerId, answer)
    }

    fun finishQuestionnaire() = questionRepository.getAnswers()


    fun sendMessage(answers: List<QuestionnaireAnswersEntity>) {
        val message = Gson().toJson(answers)
        Log.d("message send ", message)
        SendDataService().execute(message)
    }
}