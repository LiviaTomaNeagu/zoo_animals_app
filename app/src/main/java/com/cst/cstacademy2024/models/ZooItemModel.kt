package com.cst.cstacademy2024.models

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class ContinentType(
    val key: Int,
    val backgroundColor: String,
    val textAlign: String,
    val hasDivider: Boolean
) {
    EUROPE(0, "green", "left", false),
    AFRICA(1, "yellow", "left", true),
    ASIA(2, "red", "center", true),
    NORTH_AMERICA(3, "brown", "right", false),
    SOUTH_AMERICA(4, "orange", "right", true),
    AUSTRALIA(5, "purple", "center", false),
    ANTARCTICA(6, "blue", "center", true),
    OTHER(7, "white", "center", false)
}

@Entity
data class ZooAnimalModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    val animalName: String,
    val continent: String,
   // val type: ContinentType  // Using an enum to represent the type if needed.
)

