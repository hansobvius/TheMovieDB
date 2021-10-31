package com.example.themoviedb.database.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private const val APP_DATABASE = "APP_DATABASE"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            synchronized(this){
                val bufferInstance: AppDatabase?
                if(instance == null) {
                    bufferInstance = Room.databaseBuilder(
                       context.applicationContext,
                       AppDatabase::class.java,
                       APP_DATABASE)
                        .fallbackToDestructiveMigration()
                        .build()
                    instance = bufferInstance
                }
            }
            return instance
        }
    }
}