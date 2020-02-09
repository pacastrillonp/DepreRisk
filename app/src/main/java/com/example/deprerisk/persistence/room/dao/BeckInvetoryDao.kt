package com.example.deprerisk.persistence.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity

@Dao
interface BeckInventoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(question: BeckInventoryEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMany(questionList: List<BeckInventoryEntity>)

    @Query("SELECT * FROM ${BeckInventoryEntity.TABLE_NAME}")
    fun getAllQuestions(): LiveData<List<BeckInventoryEntity>>

    @Query("SELECT * FROM ${BeckInventoryEntity.TABLE_NAME} WHERE id = :id")
    fun getQuestion(id: Int): LiveData<BeckInventoryEntity>

    @Query("DELETE FROM ${BeckInventoryEntity.TABLE_NAME} WHERE id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM  ${BeckInventoryEntity.TABLE_NAME}")
    fun deleteAll()

}