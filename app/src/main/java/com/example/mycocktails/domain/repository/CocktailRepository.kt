package com.example.mycocktails.domain.repository

import com.example.mycocktails.domain.entity.Cocktail

interface CocktailRepository {
    suspend fun getAllCocktails(): List<Cocktail>

    suspend fun addNewCocktails(cocktail: Cocktail)

    suspend fun getCocktailById(id: Long): Cocktail
}