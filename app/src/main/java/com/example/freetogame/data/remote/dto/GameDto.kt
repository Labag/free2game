package com.example.freetogame.data.remote.dto
import com.example.freetogame.data.model.Game
import com.example.freetogame.data.model.Screenshot
import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val imageUrl: String,
    @SerializedName("status") val status: String?,
    @SerializedName("short_description") val shortDescription: String,
    @SerializedName("description") val description: String?,
    @SerializedName("genre") val genre: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("developer") val developer: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("screenshots") val screenshots: List<Screenshot>?,
)

fun GameDto.toGame() : Game {
    return Game(
        id = id,
        title = title,
        imageUrl = imageUrl,
        shortDescription = shortDescription,
        description = description,
        genre = genre,
        status = status,
        platform = platform,
        publisher = publisher,
        developer = developer,
        releaseDate = releaseDate,
        screenshots = screenshots.orEmpty().map { it.imageUrl }
    )
}
