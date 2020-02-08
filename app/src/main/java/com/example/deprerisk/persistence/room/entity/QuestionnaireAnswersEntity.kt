package com.example.deprerisk.persistence.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity.Companion.TABLE_NAME
import org.jetbrains.annotations.NotNull

@Entity(tableName = TABLE_NAME)
data class QuestionnaireAnswersEntity(
    @ColumnInfo(name = "answers1") var answers1: String,
    @ColumnInfo(name = "answers2") var answers2: String,
    @ColumnInfo(name = "answers3") var answers3: String,
    @ColumnInfo(name = "answers4") var answers4: String,
    @ColumnInfo(name = "answers5") var answers5: String,
    @ColumnInfo(name = "answers6") var answers6: String,
    @ColumnInfo(name = "answers7") var answers7: String,
    @ColumnInfo(name = "answers8") var answers8: String,
    @ColumnInfo(name = "answers9") var answers9: String,
    @ColumnInfo(name = "answers10") var answers10: String,
    @ColumnInfo(name = "answers11") var answers11: String,
    @ColumnInfo(name = "answers12") var answers12: String,
    @ColumnInfo(name = "answers13") var answers13: String,
    @ColumnInfo(name = "answers14") var answers14: String,
    @ColumnInfo(name = "answers15") var answers15: String,
    @ColumnInfo(name = "answers16") var answers16: String,
    @ColumnInfo(name = "answers17") var answers17: String,
    @ColumnInfo(name = "answers18") var answers18: String,
    @ColumnInfo(name = "answers19") var answers19: String,
    @ColumnInfo(name = "answers20") var answers20: String,
    @ColumnInfo(name = "answers21") var answers21: String
) {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var answersId: Long = 0

    companion object {
        const val TABLE_NAME = "answers_table"
    }
}




























