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
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nrg.hilttest.ui.theme.LightPurple
import com.nrg.hilttest.ui.theme.Orange
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
    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier.padding(16.dp), elevation = 0.dp, backgroundColor = Color.White
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
                    }, modifier = Modifier.padding(start = 10.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                BadgedBox(modifier = Modifier.padding(end = 10.dp), badge = {
                    Badge(
                        Modifier
                            .clip(CircleShape)
                            .background(Color.Red)
                            .align(Alignment.BottomEnd)
                    ) {
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
                            topStart = 20.dp, topEnd = 20.dp
                        )
                    ), elevation = 5.dp, backgroundColor = Color.Black
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BottomNavigationItem(selected = true,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "Bottom nav person"
                            )

                        })
                    BottomNavigationItem(selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Fullscreen,
                                contentDescription = "Bottom nav person"
                            )

                        })
                    BottomNavigationItem(selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.Tune,
                                contentDescription = "Bottom nav person"
                            )
                        })
                    BottomNavigationItem(selected = false,
                        onClick = { },
                        selectedContentColor = Color.White,
                        icon = {
                            Icon(
                                imageVector = Icons.Outlined.RadioButtonUnchecked,
                                contentDescription = "Bottom nav person"
                            )

                        })

                }
            }
        }) {
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
            Spacer(modifier = Modifier.size(30.dp))

            Box(
                Modifier
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(10))
                    .background(color = LightPurple)
            ) {
                Column(
                    Modifier.padding(
                        horizontal = 20.dp, vertical = 22.dp
                    )
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Loose\nbelly fat",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp
                        )

                        Button(
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(6.dp),
                            onClick = {},
                            colors = ButtonDefaults.textButtonColors(
                                backgroundColor = colorResource(id = R.color.purple_200)
                            )
                        ) {

                            Text(text = "Middle level", color = Color.White, fontSize = 18.sp)

                        }
                    }

                    Spacer(modifier = Modifier.size(15.dp))

                    Box(
                        Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.White)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.weight(0.5f))
                            Image(
                                painter = painterResource(id = R.drawable.dumbbells),
                                contentDescription = "dumbbells",
                                modifier = Modifier.size(200.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Schedule,
                            contentDescription = "Time icons",
                            tint = Color.Black
                        )

                        Text(
                            text = "40 Minutes",
                            color = Color.Black,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 5.dp)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        TextButton(
                            colors = ButtonDefaults.textButtonColors(
                                backgroundColor = Color.Transparent
                            ),
                            onClick = { /*TODO*/ }
                        ) {
                            Text(
                                "CLICK",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Icon(
                                imageVector = Icons.Outlined.ArrowForward,
                                contentDescription = "Time icons",
                                tint = Color.Black
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.size(20.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Orange)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(75.dp),
                            color = Color.Black,
                            progress = 0.56f,
                            strokeWidth = 8.dp
                        )

                        Text(
                            text = "56%",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                    }

                    Column {
                        Text(
                            text = "Great!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "You've lost 56% of your\ndaily calorie!",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    }
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