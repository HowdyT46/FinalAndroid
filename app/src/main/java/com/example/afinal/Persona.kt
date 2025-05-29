package com.example.persona5app.model

data class Persona(
    val id: String,
    val name: String,
    val arcana: String,
    val level: Int,
    val stats: Map<String, Int>,
    val skills: Map<String, Int>
)

