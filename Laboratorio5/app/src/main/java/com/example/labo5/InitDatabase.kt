package com.example.labo5

import android.app.Application
import androidx.room.Room
import com.example.labo5.data.database.AppDatabase

class InitDatabase : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "tasks_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}