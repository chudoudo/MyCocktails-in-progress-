package com.example.mycocktails.domain.usecase

import com.example.mycocktails.domain.entity.Cocktail
import com.example.mycocktails.domain.repository.CocktailRepository
import javax.inject.Inject

class AddNewCocktailUseCase @Inject constructor(private val repository: CocktailRepository) {
    suspend operator fun invoke(cocktail: Cocktail) =
        repository.addNewCocktails(cocktail)
}