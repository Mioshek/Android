package com.example.dessertclicker.data

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class DessertUiState (
    val dessertsSold: Int = 0,
    val totalRevenue: Int = 0,
    val currentDessert: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessert].price,
    @DrawableRes val dessertImageId: Int = dessertList[currentDessert].imageId,
)