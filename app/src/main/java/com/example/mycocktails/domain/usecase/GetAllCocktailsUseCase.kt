package com.example.mycocktails.domain.usecase

import com.example.mycocktails.domain.repository.CocktailRepository
import javax.inject.Inject

class GetAllCocktailsUseCase @Inject constructor(private val repository: CocktailRepository) {
    suspend operator fun invoke() =
        repository.getAllCocktails()
}