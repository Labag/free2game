package com.example.freetogame.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GameClient {
    private const val BASE_URL = "https://www.freetogame.com/"

    fun create(): GameApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApiService::class.java)
    }
}