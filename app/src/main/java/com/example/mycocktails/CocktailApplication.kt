package com.example.mycocktails

import android.app.Application
import com.example.mycocktails.di.ApplicationComponent
import com.example.mycocktails.di.DaggerApplicationComponent


class CocktailApplication : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

}

