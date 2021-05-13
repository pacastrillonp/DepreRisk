package com.example.deprerisk.persistence.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity

@Dao
interface QuestionnaireAnswersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAnswer(answersEntity: QuestionnaireAnswersEntity)

    @Query("SELECT * FROM ${QuestionnaireAnswersEntity.TABLE_NAME}")
    fun getAllAnswers(): LiveData<List<QuestionnaireAnswersEntity>>

    @Query("DELETE FROM ${QuestionnaireAnswersEntity.TABLE_NAME} WHERE answersId = :answersId")
    fun delete(answersId: Long)

    @Query("DELETE FROM  ${QuestionnaireAnswersEntity.TABLE_NAME}")
    fun deleteAll()
}