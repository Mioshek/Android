package com.example.unscrumble.data

import androidx.annotation.StringRes

const val MAX_NUMBER_OF_WORDS = 10
const val SCORE_INCREASE = 20

data class Word (
    @StringRes val word: Int,
    var isGuessCorrect: Boolean,
    var guessedWord: String?
    )