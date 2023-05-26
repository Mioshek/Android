package com.example.unscrumble.ui.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscrumble.R
import com.example.unscrumble.data.MAX_NUMBER_OF_WORDS
import com.example.unscrumble.data.Word
import com.example.unscrumble.data.usedWords
import com.example.unscrumble.data.words

@Composable
fun GameScreen(modifier: Modifier = Modifier){
    var word by rememberSaveable{
        mutableStateOf(R.string.word_1)
    }
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
            word = word,
            currentRound = 1,
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
                modifier = modifier
                    .fillMaxWidth(),
                onClick = {},
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = modifier.clip(shapes.large)
                )
            }

            OutlinedButton(
                onClick = {
                          getWord()
                },
                modifier = modifier
                    .fillMaxWidth()
                    .clip(shapes.medium),
            ) {
                Text(
                    text = stringResource(R.string.skip),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = modifier,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        GameScore(score = 0, modifier = Modifier)
    }
}

fun getWord(): Word {
    val word = words.random()
    usedWords.remove(word)
    return word
}

@Composable
fun GameLayout(@StringRes word: Int, currentRound: Int, modifier: Modifier = Modifier){
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
                text = stringResource(word),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3
            )

            OutlinedTextField(
                value = "",
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                onValueChange = {},
                label = { Text(stringResource(R.string.enter_your_word)) },
                isError = false,
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
fun FinalScoreDialog(){

}