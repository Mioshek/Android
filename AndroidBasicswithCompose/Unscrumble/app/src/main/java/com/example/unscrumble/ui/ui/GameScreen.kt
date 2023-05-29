package com.example.unscrumble.ui.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscrumble.R
import com.example.unscrumble.data.usedWords
import com.example.unscrumble.data.words

@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()){
    val gameUiState by gameViewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h4,
        )
        GameLayout(
            onUserGuessChanged = { gameViewModel.updateUserGuess(it)},
            userGuess = gameViewModel.userGuess,
            onKeyboardDone = {gameViewModel.checkUserGuess()},
            isGuessedWrong = gameUiState.isGuessedWrong,
            currentWord = gameUiState.currentScrambledWord,
            currentRound = gameUiState.currentWordCount,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {gameViewModel.checkUserGuess()},
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.clip(shapes.large)
                )
            }

            OutlinedButton(
                onClick = { gameViewModel.skipWord()},
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shapes.medium),
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        GameScore(score = gameUiState.score, modifier = Modifier)

        if(gameUiState.isGameOver){
            FinalScoreDialog(
                score = gameUiState.score,
                onPlayAgain = {gameViewModel.resetGame()}
            )
        }
    }
}

fun getWord(): String {
    var currentWord = words.random()
    while (currentWord in usedWords){
        currentWord = words.random()
    }
    usedWords.add(currentWord)
    return currentWord
}

@Composable
fun GameLayout(
    userGuess: String,
    onUserGuessChanged: (String) -> Unit,
    isGuessedWrong: Boolean,
    onKeyboardDone: () -> Unit,
    currentWord: String,
    currentRound: Int,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "$currentRound/$MAX_NUMBER_OF_WORDS",
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(MaterialTheme.colors.secondary)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End)
            )

            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = currentWord,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3
            )

            OutlinedTextField(
                value = userGuess,
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = onUserGuessChanged,
                label = {
                        if (isGuessedWrong){
                            Text(stringResource(R.string.wrong_guess))
                        }else{
                            Text(stringResource(R.string.enter_your_word))
                        }
                },
                isError = isGuessedWrong,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {})
            )
        }
    }
}

@Composable
fun GameScore(score: Int, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Text(
            text = stringResource(R.string.score) + ": " + score,
            modifier.padding(10.dp),
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
private fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
){
    val activity = (LocalContext.current as Activity)
    
    AlertDialog(
        onDismissRequest = {
            
        },
        title = { Text(text = stringResource(R.string.congratulations))},
        text = { Text(text = stringResource(R.string.you_scored, score)) },
        modifier = modifier,
        dismissButton ={
            TextButton(onClick = { activity.finish() }) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    )
}