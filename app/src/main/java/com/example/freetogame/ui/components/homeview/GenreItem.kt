package com.example.freetogame.ui.components.homeview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GenreItem(
    genre: String,
    selectedGenre: String?,
    onClick: () -> Unit
) {
    val backgroundColor = if (genre == selectedGenre) Color.Blue else Color(0xFFF5F5F5)
    val textColor = if (genre == selectedGenre) Color.White else Color.Black
    val shadowElevation = if (genre == selectedGenre) 8.dp else 2.dp

    Text(
        text = genre,
        modifier = Modifier
            .shadow(shadowElevation, shape = RoundedCornerShape(16.dp))
            .background(backgroundColor, shape = RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        color = textColor,
        style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.SemiBold
        )
    )
}
