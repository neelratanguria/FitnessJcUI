package com.nrg.hilttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fullscreen
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.*
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
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                elevation = 5.dp,
                backgroundColor = Color.Black
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(imageVector = Icons.Filled.Person,
                                contentDescription = "Bottom nav person")

                        }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(imageVector = Icons.Default.Fullscreen,
                                contentDescription = "Bottom nav person")

                        }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Tune,
                                contentDescription = "Bottom nav person"
                            )
                        }
                    )
                    BottomNavigationItem(
                        selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.RadioButtonUnchecked,
                                contentDescription = "Bottom nav person"
                            )

                        }
                    )

                }
            }
        }
    ) {
        Column(
            Modifier.padding(it)
        ) {
            Spacer(modifier = Modifier.size(15.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(workOutCategories.size) {
                    WorkOutType(workout = workOutCategories[it])
                }
            }
        }
    }
}

@Composable
fun WorkOutType(workout: String) {
    var selected by remember { mutableStateOf(false) }
    val backgroundColor = if (selected) Color.Black else Color.White
    val textColor = if (selected) Color.White else Color.Black

    OutlinedButton(
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(6.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
        onClick = { selected = !selected },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(text = workout, color = textColor, fontSize = 18.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StoreAppTheme {
        Content()
    }
}