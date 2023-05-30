package com.example.unscramble.ui.test

import com.example.unscramble.data.getUnscrambledWord
import com.example.unscrumble.ui.ui.GameViewModel
import com.example.unscrumble.ui.ui.SCORE_INCREASE
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun correctWordGuessed_ScoreUpdatedAndErrorFlagUnset(){
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)

        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()
        currentGameUiState = viewModel.uiState.value

        assertFalse(currentGameUiState.isGuessedWrong)
        assertEquals(20, currentGameUiState.score)
    }

    companion object{
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}