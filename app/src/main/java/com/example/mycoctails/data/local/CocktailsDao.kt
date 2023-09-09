package com.example.mycoctails.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mycoctails.data.local.model.CocktailDbModel

@Dao
interface CocktailsDao {
    @Insert
    suspend fun insertNewCocktail(data: CocktailDbModel): Long

    @Query("SELECT * FROM cocktails")
    suspend fun getAllCocktails(): List<CocktailDbModel>

    @Query("SELECT * FROM cocktails WHERE id=:id")
    suspend fun getCocktailById(id: Long): CocktailDbModel
}