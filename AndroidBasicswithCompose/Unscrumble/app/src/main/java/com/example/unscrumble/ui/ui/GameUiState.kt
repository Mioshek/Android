package com.example.unscrumble.ui.ui

const val MAX_NUMBER_OF_WORDS = 10
const val SCORE_INCREASE = 20

data class GameUiState (
//    val currentWord: Word = Word("", null, false,"")
    var unscrambledWord: String = "",
    val currentScrambledWord: String = "",
    val currentWordCount: Int = 1,
    val score: Int = 0,
    val isGuessedWrong: Boolean = false,
    val isGameOver: Boolean = false
)