package com.example.mycocktails.data.implementation

import com.example.mycocktails.data.local.CocktailsDao
import com.example.mycocktails.data.local.IngredientsDao
import com.example.mycocktails.domain.entity.Cocktail
import com.example.mycocktails.data.local.model.IngredientDbModel
import com.example.mycocktails.data.toDbModel
import com.example.mycocktails.data.toEntity
import com.example.mycocktails.domain.repository.CocktailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailRepositoryImpl @Inject constructor(
    private val cocktailsDao: CocktailsDao,
    private val ingredientsDao: IngredientsDao
) : CocktailRepository {
    override suspend fun getAllCocktails(): List<Cocktail> = withContext(Dispatchers.IO) {
        val cocktailDbModels = cocktailsDao.getAllCocktails()
        cocktailDbModels.map { cocktail ->
            val ingredients =
                ingredientsDao.getIngredientsByCocktailId(cocktail.id).map { it.description }
            cocktail.toEntity(ingredients)
        }
    }

    override suspend fun addNewCocktails(cocktail: Cocktail) = withContext(Dispatchers.IO) {
        val cocktailId = cocktailsDao.insertNewCocktail(cocktail.toDbModel())
        val ingredients = cocktail.ingredients.map { description ->
            IngredientDbModel(
                cocktailId = cocktailId,
                description = description
            )
        }
        ingredientsDao.insertIngredients(ingredients)
    }

    override suspend fun getCocktailById(id: Long): Cocktail = withContext(Dispatchers.IO) {
        val cocktailDbModel = cocktailsDao.getCocktailById(id)
        val ingredients = ingredientsDao.getIngredientsByCocktailId(cocktailDbModel.id)
            .map { it.description }
        return@withContext cocktailDbModel.toEntity(ingredients)
    }
}