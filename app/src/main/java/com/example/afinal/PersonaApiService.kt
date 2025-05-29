package com.example.persona5app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.persona5app.model.Persona

interface PersonaApiService {
    @GET("personas")
    suspend fun getAllPersonas(): List<Persona>

    @GET("personas/{id}")
    suspend fun getPersonaById(@Path("id") id: String): Persona

    @GET("confidants")
    suspend fun getAllConfidants(): List<Confidant>
}

object RetrofitInstance {
    private const val BASE_URL = "https://megamitensei.fandom.com/es/wiki/Categor%C3%ADa:Personajes_de_Persona_5/"

    val api: PersonaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PersonaApiService::class.java)
    }
}

data class Confidant(
    val name: String,
    val arcana: String,
    val benefits: Map<Int, String>
)