package com.example.mycoctails.domain.repository

import com.example.mycoctails.domain.entity.Cocktail

interface CocktailRepository {
    suspend fun getAllCocktails(): List<Cocktail>

    suspend fun addNewCocktails(cocktail: Cocktail)

    suspend fun getCocktailById(id: Long): Cocktail
}