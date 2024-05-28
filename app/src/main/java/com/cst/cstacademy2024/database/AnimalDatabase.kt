package com.cst.cstacademy2024.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.cstacademy2024.models.ZooAnimalModel


@Database(entities = [ZooAnimalModel::class], version = 1)
abstract class AnimalDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "animal_database"
    }

    abstract fun animalDao(): AnimalDao
}