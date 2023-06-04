package com.nrg.hilttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nrg.hilttest.ui.theme.StoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreAppTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content() {
    val workOutCategories = listOf("Full body", "Cardio", "Cross Fit", "Cyclist", "Glutes", "Power")
    Scaffold(
        topBar = {
                 TopAppBar(
                     modifier = Modifier.padding(16.dp),
                     elevation = 0.dp,
                     backgroundColor = Color.White
                 ) {
                     Row(
                         modifier = Modifier
                             .fillMaxSize()
                             .padding(horizontal = 5.dp),
                         verticalAlignment = Alignment.CenterVertically
                     ) {
                         Box(
                             modifier = Modifier
                                 .fillMaxHeight()
                                 .aspectRatio(1f)
                                 .clip(CircleShape)
                                 .background(Color.Black)
                         ) {
                             Image(
                                 painter = painterResource(id = R.drawable.profile),
                                 contentDescription = "Profile Picture",
                                 contentScale = ContentScale.Crop,
                                 modifier = Modifier
                                     .scale(2f)
                                     .aspectRatio(.5f)
                                     .offset(y = 12.dp)
                                     .align(Alignment.TopCenter)

                             )
                         }


                         Text(
                             buildAnnotatedString {
                             append("Hello, ")
                             withStyle(
                                 SpanStyle(
                                     color = Color.Black,
                                     fontWeight = FontWeight.Bold,
                                     fontSize = 20.sp
                                 )
                             ) {
                                 append("Gláucio")
                             }
                         },
                             modifier = Modifier.padding(start = 10.dp))
                         
                         Spacer(modifier = Modifier.weight(1f))

                         BadgedBox(
                             modifier = Modifier.padding(end = 10.dp),
                             badge = {
                             Badge(
                                 Modifier
                                     .clip(CircleShape)
                                     .background(Color.Red)
                                     .align(Alignment.BottomEnd)
                             ){
                                 Text(text = "1")
                             }
                         }) {
                             Icon(
                                 imageVector = Icons.Filled.Notifications,
                                 contentDescription = "Notification button",
                                 tint = Color.Black
                             )
                         }
                     }
                 }
        },
        bottomBar = {

        }
    ) {
        Surface(
            Modifier.padding(it)
        ) {
            
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StoreAppTheme {
        Content()
    }
}