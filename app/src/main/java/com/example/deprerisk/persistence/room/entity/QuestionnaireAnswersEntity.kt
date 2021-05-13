package com.example.deprerisk.persistence.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity.Companion.TABLE_NAME
import org.jetbrains.annotations.NotNull

@Entity(tableName = TABLE_NAME)
data class QuestionnaireAnswersEntity(
    @PrimaryKey @NotNull @ColumnInfo(name = "answersId") var answersId: Int,
    @NotNull @ColumnInfo(name = "answers") var answers: String
) {
    companion object {
        const val TABLE_NAME = "answers_table"
    }
}




























