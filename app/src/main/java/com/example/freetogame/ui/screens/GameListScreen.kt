package com.example.freetogame.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.freetogame.ui.components.homeview.GameList
import com.example.freetogame.ui.components.homeview.GenreList
import com.example.freetogame.ui.viewmodels.GameViewModel

@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    gameViewModel: GameViewModel
) {
    val games by gameViewModel.games.collectAsStateWithLifecycle()
    var isExpanded by remember { mutableStateOf(false) }

    var selectedGenre by remember { mutableStateOf<String?>(null) }

    val filteredGames = if (selectedGenre != null) {
        games.filter { it.genre == selectedGenre }
    } else {
        games
    }

    if (games.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        return
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = "Free2Game",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            GenreList(
                genres = games.map { it.genre }.distinct(),
                selectedGenre = selectedGenre,
                onGenreClick = { genre ->
                    selectedGenre = if (selectedGenre == genre) null else genre
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            GameList(
                games = filteredGames,
                onGameClick = { gameId ->
                    gameViewModel.selectGame(gameId)
                    navController.navigate("gameDetail")
                }
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
            ) {
            if (isExpanded) {
                GameViewModel.SortMode.entries.forEach { mode ->
                    FloatingActionButton(
                        onClick = {
                            gameViewModel.sortData(mode)
                            isExpanded = false
                        },
                        modifier = Modifier.size(width = 100.dp, height = 50.dp)
                    ) {
                        Text(
                            text = mode.display
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = { isExpanded = !isExpanded },
                modifier = Modifier.size(64.dp)
            ) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.Close else Icons.AutoMirrored.Filled.Sort,
                    contentDescription = if (isExpanded) "Close" else "Sort"
                )
            }
        }
    }
}