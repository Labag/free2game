package com.example.freetogame.ui.components.detailsview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameInformations(
    modifier: Modifier = Modifier,
    developer: String,
    publisher: String,
    genre: String,
    releaseDate: String,
    platform: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray.copy(alpha = 0.2f))
            .padding(16.dp)
    ) {
        Text(
            text = "Informations",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        HorizontalDivider(
            modifier = Modifier.padding(bottom = 8.dp),
            thickness = 1.dp,
            color = Color.Gray
        )

        InformationRow(label = "Publisher", value = publisher)
        Spacer(modifier = Modifier.height(8.dp))
        InformationRow(label = "Genre", value = genre)
        Spacer(modifier = Modifier.height(8.dp))
        InformationRow(label = "Release date", value = releaseDate)
        Spacer(modifier = Modifier.height(8.dp))
        InformationRow(label = "Platform", value = platform)
        Spacer(modifier = Modifier.height(8.dp))
        InformationRow(label = "Developer", value = developer)
    }
}
