package com.oceanbrasil.oceanrickandmortygame

import androidx.room.Entity

@Entity(tableName = "rmcharacters")
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val image:String
)
