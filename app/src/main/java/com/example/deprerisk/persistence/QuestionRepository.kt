package com.example.deprerisk.persistence

import androidx.lifecycle.LiveData
import com.example.deprerisk.persistence.room.dao.BeckInventoryDao
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity

class QuestionRepository(private val beckInventoryDao: BeckInventoryDao) {

    val allQuestions: LiveData<List<BeckInventoryEntity>> = beckInventoryDao.getAllQuestions()

    fun getQuestion(id: Int): LiveData<BeckInventoryEntity> {
        return beckInventoryDao.getQuestion(id)
    }


}



































