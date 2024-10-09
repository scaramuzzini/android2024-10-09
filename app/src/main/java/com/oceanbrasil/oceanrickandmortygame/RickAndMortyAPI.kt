package com.oceanbrasil.oceanrickandmortygame

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyAPI {
    @GET("character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>
}