package com.example.mycoctails.data.implementation

import com.example.mycoctails.data.local.CocktailsDao
import com.example.mycoctails.data.local.IngredientsDao
import com.example.mycoctails.domain.entity.Cocktail
import com.example.mycoctails.data.local.model.IngredientDbModel
import com.example.mycoctails.data.toDbModel
import com.example.mycoctails.data.toEntity
import com.example.mycoctails.domain.repository.CocktailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CocktailRepositoryImpl (
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