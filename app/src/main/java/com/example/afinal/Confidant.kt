package com.example.persona5app.model

data class Confidant(
    val name: String,
    val arcana: String,
    val benefits: Map<Int, String>
)

