package com.example.mycoctails.domain.usecase

import com.example.mycoctails.domain.repository.CocktailRepository

class GetAllCocktailsUseCase(private val repository: CocktailRepository) {
    suspend operator fun invoke() =
        repository.getAllCocktails()
}