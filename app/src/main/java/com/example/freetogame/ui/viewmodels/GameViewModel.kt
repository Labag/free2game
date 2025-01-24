package com.example.freetogame.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogame.data.model.Game
import com.example.freetogame.data.remote.GameClient
import com.example.freetogame.data.repository.GameRepositoryImpl
import com.example.freetogame.domain.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val gameApiService = GameClient.create()
    private val gameRepository: GameRepository = GameRepositoryImpl(gameApiService)

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games

    private val _selectedGame = MutableStateFlow<Game?>(null)
    val selectedGame: StateFlow<Game?> = _selectedGame

    init {
        viewModelScope.launch {
            try {
                gameRepository.getAllGames().collect { gameList ->
                    _games.value = gameList
                }
            } catch (e: Exception) {
                println(("NetworkError" + e.message))
            }
        }
    }

    fun selectGame(gameId: Int) {
        if (_selectedGame.value == null || selectedGame.value!!.id != gameId) {
            _selectedGame.value = null
            viewModelScope.launch {
                gameRepository.getGameById(gameId).collect { game ->
                    _selectedGame.value = game
                }
            }
        }
    }

    fun sortData(sortMode: SortMode) {
        _games.value = when (sortMode) {
            SortMode.TITLE -> _games.value.sortedBy { it.title }
            SortMode.PUBLISHER -> _games.value.sortedBy { it.publisher }
            SortMode.RELEASE_DATE -> _games.value.sortedBy { it.releaseDate }
        }
    }

    enum class SortMode(val display: String) {
        TITLE("Title"),
        PUBLISHER("Publisher"),
        RELEASE_DATE("Release date")
    }
}