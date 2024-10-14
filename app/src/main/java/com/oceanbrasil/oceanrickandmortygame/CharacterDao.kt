package com.oceanbrasil.oceanrickandmortygame

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {
    //1. Lista todos os personagens
    @Query("SELECT * FROM rmcharacters")
    fun getAllCharacters(): LiveData<List<Character>>

    //2. Insere personagens
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Character>)
}