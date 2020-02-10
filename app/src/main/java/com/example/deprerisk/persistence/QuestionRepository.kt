package com.example.deprerisk.persistence

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.deprerisk.persistence.room.dao.BeckInventoryDao
import com.example.deprerisk.persistence.room.dao.QuestionnaireAnswersDao
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity

class QuestionRepository(
    beckInventoryDao: BeckInventoryDao,
    private val questionnaireAnswersDao: QuestionnaireAnswersDao
) {

    val allQuestions: LiveData<List<BeckInventoryEntity>> = beckInventoryDao.getAllQuestions()

    fun saveAnswer(answerId: Int, answer: String) {
        AsyncTask.execute {
            questionnaireAnswersDao.insertAnswer(QuestionnaireAnswersEntity(answerId, answer))
        }
    }

    fun getAnswers(): LiveData<List<QuestionnaireAnswersEntity>> {
        return questionnaireAnswersDao.getAllAnswers()
    }
}



































