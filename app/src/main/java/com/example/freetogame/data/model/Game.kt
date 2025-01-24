package com.example.freetogame.data.model

data class Game(
    val id: Int,
    val title: String,
    val imageUrl: String = "",
    val status: String?,
    val shortDescription: String,
    val description: String?,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val releaseDate: String,
    val screenshots: List<String>
)
