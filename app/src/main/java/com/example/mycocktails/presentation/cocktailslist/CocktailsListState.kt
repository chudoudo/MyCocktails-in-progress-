package com.example.mycocktails.presentation.cocktailslist

import com.example.mycocktails.domain.entity.Cocktail

sealed class CocktailsListState {
    data object Initial : CocktailsListState()
    data class Content(val data: List<Cocktail>) : CocktailsListState()

    data object EmptyList : CocktailsListState()
}