package com.example.freetogame.data.model

import com.google.gson.annotations.SerializedName

data class Screenshot(
    @SerializedName("id") val id: Int,
    @SerializedName("image") val imageUrl: String
)
