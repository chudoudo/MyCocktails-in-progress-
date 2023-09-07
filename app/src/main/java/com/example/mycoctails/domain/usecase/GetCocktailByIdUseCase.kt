package com.example.mycoctails.domain.usecase

import com.example.mycoctails.domain.repository.CocktailRepository

class GetCocktailByIdUseCase(private val repository: CocktailRepository) {
    suspend operator fun invoke(id: Long) = repository.getCocktailById(id)
}