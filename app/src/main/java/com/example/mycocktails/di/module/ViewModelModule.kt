package com.example.mycocktails.di.module

import androidx.lifecycle.ViewModel
import com.example.mycocktails.di.annotation.ViewModelKey
import com.example.mycocktails.presentation.cocktailslist.CocktailsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CocktailsListViewModel::class)
    fun bindCocktailsListViewModel(viewModel: CocktailsListViewModel): ViewModel

}