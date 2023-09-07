package com.example.mycoctails.domain.entity

data class Cocktail (
    val id: Int = 0,
    val name: String,
    val ingredients: List<String>,
    val description: String?,
    val recipe: String?
)