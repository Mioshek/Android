package MioTech.basicsplus

import MioTech.basicsplus.ui.theme.BasicsPlusTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.BottomNavigationDefaults.Elevation
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val windowSizeClass = calculateWindowSizeClass(this)
            BasicsPlusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val artSpace = ArtSpace()
                    artSpace.RunArtSpaceApp()
                }
            }
        }
    }
}

class ArtSpace{

//    fun addPhoto(photo: Int,availableImages: List<Int>){
//        val arr = availableImages
//        return arr.add(photo)
//    }
//
//    fun removePhoto(index: Int, availableImages: List<Int>){
//        val arr = availableImages
//        return arr.remove(photo)
//    }

    private fun getNextImage(currentImageIndex: Int, availableImages: List<Int>): Int {
        val size = availableImages.size
        return if(currentImageIndex == size -1){0}
        else{currentImageIndex + 1}
    }

    private fun getPreviousImage(currentImageIndex: Int, availableImages: List<Int>): Int {
        val size = availableImages.size -1
        return if(currentImageIndex == 0){size - 1}
        else{currentImageIndex - 1}
    }

    @Composable
    fun RunArtSpaceApp(){
        ArtSpaceApp()
    }

    @Composable
    fun ArtSpaceApp(
        modifier: Modifier = Modifier
    ) {
        val availableImages by remember {
            mutableStateOf(
                listOf(R.drawable.landscape_trees_mountains_clouds_digital_art_38_1920x1080,
                    R.drawable.mmorpg_inspired_landscape_wallpaper,
                    R.drawable.wallpapersden_com_sunrise_landscape_1920x1080)
            )
        }

        val availableTitlesAndDescriptions by remember {
            mutableStateOf(
                listOf(R.string.mountain,
                    R.string.mountain_description,
                    R.string.ancient_tree,
                    R.string.ancient_tree_description,
                    R.string.cartoons_river,
                    R.string.cartoons_river_description
                )
            )
        }

        var currentIndex by remember {
            mutableStateOf(0)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .border(BorderStroke(4.dp, Color.Gray))
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(availableImages[currentIndex]),
                    contentDescription = null,
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .shadow(AppBarDefaults.TopAppBarElevation)
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(availableTitlesAndDescriptions[currentIndex * 2]),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Text(
                    text = stringResource(availableTitlesAndDescriptions[currentIndex * 2 + 1]),
                    fontSize = 15.sp
                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { currentIndex = getPreviousImage(currentIndex, availableImages) },
                        Modifier
                            .padding(end = 10.dp)
                            .width(200.dp)
                    ) {
                        Text(text = "Previous")
                    }

                    Button(
                        onClick = { currentIndex = getNextImage(currentIndex, availableImages)},
                        Modifier
                            .padding(start = 10.dp)
                            .width(200.dp)
                    ) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    BasicsPlusTheme {
        val artSpace = ArtSpace()
        artSpace.RunArtSpaceApp()
    }
}