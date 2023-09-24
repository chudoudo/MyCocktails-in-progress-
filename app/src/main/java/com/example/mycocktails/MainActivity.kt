package com.example.mycocktails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycocktails.presentation.cocktailslist.CocktailsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_fragment_container, CocktailsListFragment.newInstance(), null)
                .commit()
        }
    }
}