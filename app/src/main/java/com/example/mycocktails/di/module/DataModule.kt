package com.example.mycocktails.di.module

import android.app.Application
import com.example.mycocktails.data.implementation.CocktailRepositoryImpl
import com.example.mycocktails.data.local.CocktailDatabase
import com.example.mycocktails.data.local.CocktailsDao
import com.example.mycocktails.data.local.IngredientsDao
import com.example.mycocktails.di.annotation.ApplicationScope
import com.example.mycocktails.domain.repository.CocktailRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @Binds
    @ApplicationScope
    fun bindCocktailRepository(impl: CocktailRepositoryImpl): CocktailRepository

    companion object {

        @Provides
        fun provideCocktailsDao (application: Application): CocktailsDao =
            CocktailDatabase.getInstance(application).cocktailsDao()

        @Provides
        fun provideIngredientsDao (application: Application): IngredientsDao =
            CocktailDatabase.getInstance(application).ingredientsDao()
    }
}