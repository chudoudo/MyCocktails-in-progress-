package com.example.mycocktails.domain.usecase

import com.example.mycocktails.domain.repository.CocktailRepository
import javax.inject.Inject

class GetCocktailByIdUseCase @Inject constructor(private val repository: CocktailRepository) {
    suspend operator fun invoke(id: Long) = repository.getCocktailById(id)
}