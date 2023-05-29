package com.example.unscrumble.ui.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.unscrumble.data.usedWords
import com.example.unscrumble.data.words
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    private lateinit var currentWord: String
    private fun pickRandomWordAndShuffle(): String {
        currentWord = words.random()
        words.remove(currentWord)
        usedWords.add(currentWord)
        return shuffleCurrentWord(currentWord)
    }

    private fun shuffleCurrentWord(currentWord: String): String {
        val tempWord = currentWord.toCharArray()
        while(String(tempWord).equals(currentWord)){
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame(){
        for (word in usedWords){
            words.add(word)
        }
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    fun updateUserGuess(it: String) {
        println("it -> $it, currentWord -> $currentWord")
        userGuess = it
    }

    private fun updateGameState(updatedScore: Int){
        if (usedWords.size == MAX_NUMBER_OF_WORDS){
            _uiState.update{currentState ->
                currentState.copy(
                    isGuessedWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        }else{
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc()
                )
            }
        }
    }

    fun checkUserGuess(){
        if (userGuess.equals(currentWord, ignoreCase = true)){
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        }else{
            _uiState.update { currentState ->
                currentState.copy(isGuessedWrong = true)
            }
        }
        updateUserGuess("")
    }

    fun skipWord() {
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }

    init {
        resetGame()
    }
}