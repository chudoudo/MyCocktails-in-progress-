package com.example.mycocktails.di

import android.app.Application
import com.example.mycocktails.di.annotation.ApplicationScope
import com.example.mycocktails.di.module.DataModule
import com.example.mycocktails.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}