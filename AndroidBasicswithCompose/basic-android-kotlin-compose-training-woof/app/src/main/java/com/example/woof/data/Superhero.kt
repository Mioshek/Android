package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R

data class Superhero(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)

val superheroes = listOf<Superhero>(
    Superhero(R.string.superhero_name_1, R.drawable.android_superhero1, R.string.superhero_description_1),
    Superhero(R.string.superhero_name_2, R.drawable.android_superhero2, R.string.superhero_description_2),
    Superhero(R.string.superhero_name_3, R.drawable.android_superhero3, R.string.superhero_description_3),
    Superhero(R.string.superhero_name_4, R.drawable.android_superhero4, R.string.superhero_description_4),
    Superhero(R.string.superhero_name_5, R.drawable.android_superhero5, R.string.superhero_description_5),
    Superhero(R.string.superhero_name_6, R.drawable.android_superhero6, R.string.superhero_description_6)
)