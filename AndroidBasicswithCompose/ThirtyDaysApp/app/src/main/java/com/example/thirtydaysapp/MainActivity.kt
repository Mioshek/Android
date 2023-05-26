package com.example.thirtydaysapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysapp.data.Day
import com.example.thirtydaysapp.data.activities
import com.example.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val tdb = ThirtyDaysBetter()
                    tdb.RunThirtyDaysBetterApp()
                }
            }
        }
    }
}

class ThirtyDaysBetter{

    @Composable
    fun ThirtyDaysBetterTopBar(modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.h3,
            )
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun RunThirtyDaysBetterApp(){

        Scaffold(
            topBar = {
                ThirtyDaysBetterTopBar()
            }
        ) {
            var dayNumber by remember {
                mutableStateOf(1)
            }
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                activities.forEach {
                    DayItem(it, dayNumber)
                    dayNumber ++
                }
                dayNumber = 1
            }
        }
    }

    @Composable
    fun DayItem(day: Day,dayNumber: Int, modifier: Modifier = Modifier){
        var expanded by remember{
            mutableStateOf(false)
        }
        Card(
            modifier = Modifier
                .padding(4.dp)
                .clip(RoundedCornerShape(3)),
            elevation = 4.dp
        ) {
            Column(
                modifier = modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        )
                    )
            ) {
                ShowDayNumber(dayNumber)
                DayActivity(day)
                Spacer(modifier = modifier.padding(4.dp))
                DayImage(
                    day,
                    expanded = expanded,
                    onClick = {expanded = !expanded }
                )

                if (expanded){
                    DayExplanation(day)
                }
            }

        }
    }

    @Composable
    fun ShowDayNumber(number: Int, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .padding(2.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Day $number",
                style = MaterialTheme.typography.h4
            )
        }
    }

    @Composable
    fun DayActivity(day: Day, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .padding(8.dp),
        ) {
            Text(
                text = stringResource(day.activity),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
        }
    }

    @Composable
    fun DayImage(
        day: Day,
        expanded: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ){
        Row(
            modifier = modifier
                .padding(5.dp)
        ) {
            IconButton(onClick = onClick) {
                Box(){
                    Image(
                        painter = painterResource(day.image),
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(5)),
                        contentDescription = null,
                    )
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowRight, contentDescription = null, Modifier.size(75.dp)
                    )
                }

            }
        }
    }

    @Composable
    fun DayExplanation(day: Day, modifier: Modifier = Modifier){
        Row(
            modifier = modifier
                .padding(8.dp),
        ) {
            Text(
                text = stringResource(day.explanation),
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysAppTheme {
        Greeting("Android")
    }
}
//images from https://pixabay.com/