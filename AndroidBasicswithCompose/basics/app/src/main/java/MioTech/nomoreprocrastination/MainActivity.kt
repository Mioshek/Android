package MioTech.nomoreprocrastination

import MioTech.nomoreprocrastination.ui.theme.NoMoreProcrastinationTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt


class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoMoreProcrastinationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val tc = TipCalculator()
                    tc.RunTipCalculator()
                }
            }
        }
    }
}

class ComposeArticle{
    @Composable
    fun RunArticle(){
        Article(
            headlineMsg = stringResource(id = R.string.headlineMsg),
            first = stringResource(id = R.string.first),
            second = stringResource(id = R.string.second)
        )
    }

    @Composable
    fun Article(
        headlineMsg: String,
        first: String,
        second: String,
        modifier: Modifier = Modifier
    ){
        val imagePainter = painterResource(R.drawable.bg_compose_background)
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
            )
            Text(
                text = headlineMsg,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                text = first,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )

            Text(
                text = second,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}


class TaskManager{
    @Composable
    fun RunTaskManager(){
        TaskManagerApp(
            stringResource(R.string.tasks_completed),
            stringResource(R.string.nice_work)
        )
    }

    @Composable
    fun TaskManagerApp(completed: String, nw: String){
        val imagePainter = painterResource(R.drawable.ic_task_completed)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null
            )

            Text(
                text = completed,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = nw,
                fontSize = 16.sp
            )
        }
    }
}


class ComposeQuadrant{
    @Composable
    fun ComposeQuadrantApp() {
        Column(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(1f)) {
                ComposableInfoCard(
                    title = stringResource(R.string.first_title),
                    description = stringResource(R.string.first_description),
                    backgroundColor = Color.Green,
                    modifier = Modifier.weight(1f)
                )
                ComposableInfoCard(
                    title = stringResource(R.string.second_title),
                    description = stringResource(R.string.second_description),
                    backgroundColor = Color.Yellow,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.weight(1f)) {
                ComposableInfoCard(
                    title = stringResource(R.string.third_title),
                    description = stringResource(R.string.third_description),
                    backgroundColor = Color.Cyan,
                    modifier = Modifier.weight(1f)
                )
                ComposableInfoCard(
                    title = stringResource(R.string.fourth_title),
                    description = stringResource(R.string.fourth_description),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    @Composable
    private fun ComposableInfoCard(
        title: String,
        description: String,
        backgroundColor: Color,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
    }
}


class BusinessCard {
    @Composable
    fun RunBusinessCard(){
        BusinessCardApp()
    }

    @Composable
    fun BusinessCardApp(){
        val painterImage = painterResource(R.drawable.andorid_logo_design_on_transparent_png)
        val phoneNumberIcon = painterResource(R.drawable.add_contact)
        val contactIcon = painterResource(R.drawable.google_contacts)
        val emailIcon = painterResource(R.drawable.email)

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterImage,
                    contentDescription = null,
                    contentScale = ContentScale.None,
                )
                Text(
                    text = stringResource(R.string.name),
                    fontWeight = FontWeight.Light,
                    fontSize = 35.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = stringResource(R.string.position),
                    color = Color.Green,
                    modifier = Modifier.padding(bottom = 100.dp)
                )
            }

            Column(horizontalAlignment = Alignment.Start) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Image(painter = phoneNumberIcon, contentDescription = null, Modifier.size(24.dp))
                    Text(
                        text = stringResource(R.string.contact),
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Image(painter = contactIcon, contentDescription = null, Modifier.size(24.dp))
                    Text(
                        text = stringResource(R.string.link),
                        modifier = Modifier.padding(10.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    Image(painter = emailIcon, contentDescription = null, Modifier.size(24.dp))
                    Text(
                        text = stringResource(R.string.email),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}


class DiceRoller{
    @Composable
    fun RollDice(){
        DiceRollerApp(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }

    @Composable
    fun DiceRollerApp(modifier: Modifier = Modifier){
        var result by remember{
            mutableStateOf(1)
        }
        val imageResource = when(result){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "1"
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {result = (1..6).random()}) {
                Text(text = stringResource(R.string.roll))
            }

        }
    }


}


class LemonadeClick{
    @Composable
    fun RunLemonade(){
        LemonadeApp(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }

    @Composable
    fun LemonadeApp(modifier: Modifier = Modifier){
        var iconStateNumber by remember{
            mutableStateOf(0)
        }
        val icon = when(iconStateNumber){
            0 -> painterResource(R.drawable.lemon_tree)
            1 -> painterResource(R.drawable.lemon_squeeze)
            2 -> painterResource(R.drawable.lemon_drink)
            else -> painterResource(R.drawable.lemon_restart)
        }

        val lemonMessage = when(iconStateNumber){
            0 -> stringResource(R.string.tree)
            1 -> stringResource(R.string.lemon)
            2 -> stringResource(R.string.drinkable)
            else -> stringResource(R.string.empty)
        }

        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = lemonMessage,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            Button(
                onClick = {iconStateNumber = getNextState(iconStateNumber)}) {
                Image(painter = icon, contentDescription = null)
            }
        }
    }

    private fun getNextState(currState: Int): Int {
        return if (currState != 3 ){
            currState + 1
        } else{
            0
        }
    }
}


class TipCalculator{
    @Composable
    fun RunTipCalculator(){
        TipCalculatorApp(modifier = Modifier
            .fillMaxSize()
            )
    }

    @Composable
    fun TipCalculatorApp(modifier: Modifier = Modifier){
        var textFieldValue by remember{
            mutableStateOf("0")
        }
        var roundChecked by remember{
            mutableStateOf(false)
        }
        var percentageValue by remember {
            mutableStateOf("15")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 25.dp, bottom = 25.dp)
            )
            //Cost Of Service
            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                label = { Text(stringResource(R.string.cost_of_service)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            //Percentage
            TextField(
                value = percentageValue,
                onValueChange = { percentageValue = it },
                label = { Text(stringResource(R.string.tip_percentage)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = roundChecked, onCheckedChange = {roundChecked = !roundChecked})
                Text(text = stringResource(R.string.round_up))
            }


            Text(
                text = stringResource(R.string.tip_amount) + calculateTipValue(
                    percentageValue,
                    textFieldValue,
                    roundChecked
                    ),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 25.dp)
            )
        }
    }

    private fun calculateTipValue(percentage: String, value: String, roundOut: Boolean): Float {
        try{
            value.toInt()
            percentage.toInt()
        }catch (e: java.lang.Exception){
            return Float.NaN
        }
        if (value == "0" || value.isEmpty()){
            return 0f
        }

        return if (roundOut){
            (value.toFloat() * percentage.toInt() / 100).roundToInt().toFloat()
        } else{
            value.toFloat() * percentage.toInt() / 100
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview(){
    val ca = ComposeArticle()
    ca.RunArticle()
}

@Preview(showSystemUi = true)
@Composable
fun TaskManagerPreview(){
    val tm = TaskManager()
    tm.RunTaskManager()
}

@Preview(showSystemUi = true)
@Composable
fun ComposeQuadrantPreview(){
    val cq = ComposeQuadrant()
    cq.ComposeQuadrantApp()
}

@Preview(showSystemUi = true)
@Composable
fun BusinessCardPreview(){
    val bc = BusinessCard()
    bc.RunBusinessCard()
}

@Preview(showSystemUi = true)
@Composable
fun DiceRollerPreview(){
    val dr = DiceRoller()
    dr.RollDice()
}

@Preview(showSystemUi = true)
@Composable
fun LemonadeAppPreview(){
    val lc = LemonadeClick()
    lc.RunLemonade()
}

@Preview(showSystemUi = true)
@Composable
fun TipCalculatorPreview(){
    val tc = TipCalculator()
    tc.RunTipCalculator()
}