package com.example.freetogame.ui.components.detailsview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.freetogame.data.model.Game

@Composable
fun GameDetails(
    modifier: Modifier = Modifier,
    game: Game
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(top = 50.dp)
    ) {
        item {
            AsyncImage(
                model = game.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.LightGray)
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = game.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                )

                ImageCarousel(
                    images = game.screenshots,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                GameInformations(
                    modifier = Modifier.fillMaxWidth(),
                    publisher = game.publisher,
                    developer = game.developer,
                    genre = game.genre,
                    releaseDate = game.releaseDate,
                    platform = game.platform
                )

                GameDescription(
                    modifier = Modifier.fillMaxWidth(),
                    description = game.description
                )
            }
        }
    }
}
