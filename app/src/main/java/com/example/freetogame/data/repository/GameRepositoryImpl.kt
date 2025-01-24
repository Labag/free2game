package com.example.freetogame.data.repository

import com.example.freetogame.data.model.Game
import com.example.freetogame.data.remote.GameApiService
import com.example.freetogame.data.remote.dto.toGame
import com.example.freetogame.domain.repository.GameRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameRepositoryImpl(
    private val apiService: GameApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GameRepository {
    override fun getAllGames(): Flow<List<Game>> {
        return flow {
            emit(apiService.getAllGames().map { it.toGame() })
        }.flowOn(dispatcher)
    }

    override fun getGameById(gameId: Int): Flow<Game?> {
        return flow {
            emit(apiService.getGameById(gameId).toGame())
        }.flowOn(dispatcher)
    }
}