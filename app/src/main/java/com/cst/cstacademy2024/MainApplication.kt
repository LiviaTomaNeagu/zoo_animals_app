package com.cst.cstacademy2024

import android.app.Application
import androidx.room.Room
import com.cst.cstacademy2024.database.AnimalDatabase

class MainApplication : Application() {

    companion object {
        // Assuming the database is initialized in the Application class
        lateinit var zooDatabase: AnimalDatabase
    }

    override fun onCreate() {
        super.onCreate()
        zooDatabase = Room.databaseBuilder(applicationContext, AnimalDatabase::class.java, AnimalDatabase.DATABASE_NAME)
            .build()
    }
}