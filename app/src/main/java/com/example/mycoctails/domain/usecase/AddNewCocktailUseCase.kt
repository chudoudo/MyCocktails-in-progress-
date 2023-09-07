package com.example.mycoctails.domain.usecase

import com.example.mycoctails.domain.entity.Cocktail
import com.example.mycoctails.domain.repository.CocktailRepository

class AddNewCocktailUseCase(private val repository: CocktailRepository) {
    suspend operator fun invoke(cocktail: Cocktail) =
        repository.addNewCocktails(cocktail)
}