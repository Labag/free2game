package com.example.freetogame.data.remote

import com.example.freetogame.data.remote.dto.GameDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {
    @GET("api/games")
    suspend fun getAllGames(): List<GameDto>

    @GET("api/game")
    suspend fun getGameById(@Query("id") gameId: Int): GameDto
}