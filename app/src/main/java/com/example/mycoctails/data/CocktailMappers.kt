package com.example.mycoctails.data

import com.example.mycoctails.data.local.model.CocktailDbModel
import com.example.mycoctails.domain.entity.Cocktail

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