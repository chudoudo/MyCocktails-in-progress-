package com.example.mycocktails.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mycocktails.data.local.model.IngredientDbModel

@Dao
interface IngredientsDao {
    @Insert
    suspend fun insertIngredients(data: List<IngredientDbModel>)

    @Query("SELECT * FROM ingredients WHERE cocktailId=:cocktailId")
    suspend fun getIngredientsByCocktailId(cocktailId: Long): List<IngredientDbModel>
}