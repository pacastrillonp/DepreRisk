package com.example.deprerisk.persistence.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity.Companion.TABLE_NAME
import org.jetbrains.annotations.NotNull

@Entity(tableName = TABLE_NAME)
data class BeckInventoryEntity(

    @ColumnInfo(name = "question") var question: String,
    @ColumnInfo(name = "answerOne") var answerOne: String,
    @ColumnInfo(name = "answerTwo") var answerTwo: String,
    @ColumnInfo(name = "answerThree") var answerThree: String,
    @ColumnInfo(name = "answerFour") var answerFour: String,
    @ColumnInfo(name = "answerFive") var answerFive: String,
    @ColumnInfo(name = "answerSix") var answerSix: String,
    @ColumnInfo(name = "answerSeven") var answerSeven: String

) {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Long = 0

    companion object {
        const val TABLE_NAME = "beck_inventory_table"

    }
}




