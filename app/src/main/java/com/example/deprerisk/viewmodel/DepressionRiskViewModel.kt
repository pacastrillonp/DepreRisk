package com.example.deprerisk.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.deprerisk.SendDataService
import com.example.deprerisk.persistence.BeckQuestioners
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

    fun deleteAnswers() {
        questionRepository.deleteAnswers()
    }


    fun sendMessage(answers: List<QuestionnaireAnswersEntity>) {
        var score = 0
        answers.map { answer ->
            Log.d("answer", answer.answers)
            BeckQuestioners().answerScore().map { pair ->
                Log.d("answer pair", answer.answers)
                if (answer.answers == pair.first) {

                    score += pair.second
                    Log.d("answer score","$score")
                }
            }
        }

//        val message = Gson().toJson(answers)
        Log.d("answer total score","$score")
        SendDataService().execute(score.toString())
    }
}