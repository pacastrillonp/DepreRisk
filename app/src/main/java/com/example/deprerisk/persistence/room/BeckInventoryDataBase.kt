package com.example.deprerisk.persistence.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.deprerisk.persistence.BeckQuestioners
import com.example.deprerisk.persistence.room.dao.BeckInventoryDao
import com.example.deprerisk.persistence.room.dao.QuestionnaireAnswersDao
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(
    version = BeckInventoryDataBase.v01,
    entities = [
        BeckInventoryEntity::class,
        QuestionnaireAnswersEntity::class
    ]

)

abstract class BeckInventoryDataBase : RoomDatabase() {

    companion object {
        const val v01 = 1


        @Volatile
        private var INSTANCE: BeckInventoryDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BeckInventoryDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BeckInventoryDataBase::class.java,
                    "BeckInventoryDataBase.db"
                )
                    .addCallback(BeckInventoryDataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

    private class BeckInventoryDataBaseCallback(
        private val scope: CoroutineScope
    ) :
        RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { dataBase ->
                scope.launch {
                    val beckInventoryDao = dataBase.beckInventoryDao()
                    AsyncTask.execute {
                        beckInventoryDao.insertMany(BeckQuestioners().questions())
                    }
                }
            }
        }
    }


    abstract fun beckInventoryDao(): BeckInventoryDao
    abstract fun questionnaireAnswersDao(): QuestionnaireAnswersDao
}