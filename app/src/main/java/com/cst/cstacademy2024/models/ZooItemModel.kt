package com.cst.cstacademy2024.models

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

sealed class ZooItemModel(
    open val type: ContinentType,
    open val animalName: String,
    open val continent: String
)

data class ZooAnimalModel(
    val id: Int,
    override val animalName: String,
    override val continent: String,
    override val type: ContinentType  // I'm assuming you might want to use the type somewhere.
) : ZooItemModel(type, animalName, continent)


