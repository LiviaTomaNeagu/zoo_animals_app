package com.cst.cstacademy2024.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cst.cstacademy2024.models.ZooAnimalModel

@Dao
interface AnimalDao {
    @Query("SELECT * FROM ZooAnimalModel")
    fun getAllAnimals(): LiveData<List<ZooAnimalModel>>

    @Insert
    fun addAnimal(animal: ZooAnimalModel)

    @Query("DELETE FROM ZooAnimalModel WHERE id = :id")
    fun deleteAnimal(id: Int)
}