package com.oceanbrasil.oceanrickandmortygame

import androidx.lifecycle.LiveData

class CharacterRepository(private val characterDao: CharacterDao) {
    val allCharacters: LiveData<List<Character>> = characterDao.getAllCharacters()
    suspend fun insertAll(characters: List<Character>) {
        characterDao.insertAll(characters)
    }
}