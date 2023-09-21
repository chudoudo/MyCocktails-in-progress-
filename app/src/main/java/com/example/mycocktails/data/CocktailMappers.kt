package com.example.mycocktails.data

import com.example.mycocktails.data.local.model.CocktailDbModel
import com.example.mycocktails.domain.entity.Cocktail

fun Cocktail.toDbModel() = CocktailDbModel(
    id = id,
    name = name,
    description = description,
    recipe = recipe
)

fun CocktailDbModel.toEntity(ingredients: List<String>) = Cocktail(
    id = id,
    name = name,
    ingredients = ingredients,
    description = description,
    recipe = recipe
)