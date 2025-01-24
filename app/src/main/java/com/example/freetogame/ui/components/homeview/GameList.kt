package com.example.freetogame.ui.components.homeview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.freetogame.data.model.Game

@Composable
fun GameList(
    modifier: Modifier = Modifier,
    games: List<Game>,
    onGameClick: (gameId: Int) -> Unit
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 4.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(4.dp)
    ) {
        items(games) { game ->
            GameCard(
                title = game.title,
                imageUrl = game.imageUrl,
                releaseDate = game.releaseDate,
                genre = game.genre,
                publisher = game.publisher,
                modifier = Modifier
                    .clickable { onGameClick(game.id) }
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameList() {
    val games = listOf(
        Game(
            id = 582,
            title = "Tarisland",
            imageUrl = "https://www.freetogame.com/g/582/thumbnail.jpg",
            shortDescription = "A cross-platform MMORPG developed and published by Tencent.",
            genre = "MMORPG",
            platform = "PC (Windows)",
            publisher = "Tencent",
            developer = "Level Infinite",
            description = null,
            releaseDate = "2024-06-22",
            status = null,
            screenshots = listOf()
        ),
        Game(
            id = 540,
            title = "Overwatch 2",
            imageUrl = "https://www.freetogame.com/g/540/thumbnail.jpg",
            shortDescription = "A hero-focused first-person shooter by Blizzard Entertainment.",
            genre = "Shooter",
            platform = "PC (Windows)",
            publisher = "Activision Blizzard",
            developer = "Blizzard Entertainment",
            description = null,
            releaseDate = "2022-10-04",
            status = null,
            screenshots = listOf()
        )
    )

    GameList(
        games = games,
        onGameClick = {}
    )
}
