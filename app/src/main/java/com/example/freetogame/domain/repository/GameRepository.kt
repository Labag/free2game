package com.example.freetogame.domain.repository

import com.example.freetogame.data.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {
    fun getAllGames(): Flow<List<Game>>
    fun getGameById(gameId: Int): Flow<Game?>
}