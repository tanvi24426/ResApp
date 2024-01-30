package com.example.new_year_resolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.new_year_resolutions.ui.theme.New_year_resolutionsTheme
import com.example.new_year_resolutions.ui.theme.Green1
import com.example.new_year_resolutions.ui.theme.Green2
import com.example.new_year_resolutions.ui.theme.Linear1Green
import com.example.new_year_resolutions.ui.theme.Linear1White
import com.example.new_year_resolutions.ui.theme.Linear1Yellow
import com.example.new_year_resolutions.ui.theme.Linear2Green
import com.example.new_year_resolutions.ui.theme.Linear2White
import com.example.new_year_resolutions.ui.theme.Yellow1

class MainActivity : ComponentActivity() {

    private val resolutionState= mutableStateOf(resolutions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            New_year_resolutionsTheme {
                MyScreen(resolutionState)
            }
        }
    }
}

@Composable
fun MyScreen(resolutionState: MutableState<List<Resolution>>){

    val gradientColor= listOf(Linear1Green, Linear1White, Linear1Yellow)
    val gradientBrush= Brush.linearGradient(
        colors = gradientColor
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ){
        MyWaveImageHeader(resolutionState)
        LazyColumnEg(categories = resolutionState.value)
    }
}

@Composable
fun MyWaveImageHeader(resolutionState: MutableState<List<Resolution>>){
    var showAddAlert =remember{
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        ){

        Image(painter = painterResource(id = R.drawable.vector_5) ,
            contentDescription ="top wave",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
        )

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text="My New Year's",
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    Font(R.font.playfairdisplay_regular)
                ),
                fontWeight = FontWeight(400)
            )
            Text(
                text = "Resolutions",
                fontSize = 38.sp,
                fontFamily = FontFamily(
                    Font(R.font.playfairdisplay_black)
                ),
                fontWeight = FontWeight(500),
                color= Green1
            )
        }

        FloatingActionButton(
            onClick = {
                showAddAlert.value=true
            },
            modifier = Modifier
                .padding(top = 26.dp, end = 30.dp)
                .align(Alignment.BottomEnd),
            backgroundColor = Yellow1
        ) {
            Icon(imageVector = Icons.Default.Add , contentDescription ="Add Icon", tint= Color.White )
        }
    }
}

@Composable
fun CustomItem(resolution: Resolution){

    val gradientcolor= listOf(Linear2Green, Linear2White)
    val gradientbrush=Brush.linearGradient(
        colors = gradientcolor
    )

    Card(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)

    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(brush = gradientbrush)
        ){
            Text(
                text=resolution.name,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.playfairdisplay_regular)),
                fontWeight = FontWeight(500),
                color = Green2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(15.dp)

            )
            Spacer(modifier = Modifier.padding(5.dp))

            Image(painter = painterResource(id = R.drawable.baseline_edit_24) ,
                contentDescription ="edit icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(38.dp)
                    .padding(end = 2.dp)
            )
            Image(painter = painterResource(id = R.drawable.delete_icon) ,
                contentDescription ="edit icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(38.dp)
                    .padding(end = 2.dp)
            )
        }

    }

}


@Composable
fun LazyColumnEg(categories: List<Resolution>){
    LazyColumn(modifier = Modifier.padding(vertical = 8.dp)){
        categories.forEach { resolution ->
            item{
                CustomItem(resolution = resolution)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    New_year_resolutionsTheme {
    }
}