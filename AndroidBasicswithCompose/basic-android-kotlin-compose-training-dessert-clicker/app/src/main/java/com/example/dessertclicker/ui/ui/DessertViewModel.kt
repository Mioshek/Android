package com.example.dessertclicker.ui.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.data.DessertUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()


    fun onDessertClicked(){
        _dessertUiState.update {currentState ->
            currentState.copy(
                dessertsSold = currentState.dessertsSold.inc(),
                totalRevenue = currentState.totalRevenue + currentState.currentDessertPrice,
            )
        }
        checkIfNewDessert()
    }

    fun checkIfNewDessert(){
        if (_dessertUiState.value.dessertsSold == dessertList[_dessertUiState.value.currentDessert + 1].startProductionAmount){
            _dessertUiState.update {currentState ->
                currentState.copy(
                    currentDessert = currentState.currentDessert.inc(),
                    currentDessertPrice = dessertList[currentState.currentDessert + 1].price,
                    dessertImageId = dessertList[currentState.currentDessert + 1].imageId
                )
            }
        }
    }
}