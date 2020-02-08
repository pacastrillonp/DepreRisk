package com.example.deprerisk.persistence.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = BeckInventoryDataBase.v01,
    entities = [BeckInventoryEntity::class]
)

abstract class BeckInventoryDataBase : RoomDatabase() {


    companion object {
        const val v01 = 1

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BeckInventoryDataBase? = null

        fun getDatabase(context: Context): BeckInventoryDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        BeckInventoryDataBase::class.java,
                        "BeckInventoryDataBase.db"
                    ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
    abstract fun beckInventoryDao(): BeckInventoryDao
}