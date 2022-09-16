package com.stanley.testcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stanley.testcomposable.ui.theme.TestComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CounterDisplay()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterDisplay(){
    var editText by remember {
        mutableStateOf("")
    }

    var counterText by remember {
        mutableStateOf("Start Copying")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier.testTag("Counter Display"),
            text = counterText,
            style = TextStyle(
                fontSize = 36.sp,
                color = Color.White
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .testTag("Input"),
            value = editText,
            onValueChange = {
                editText = it
            },
            label = {
                Text("Input")
            },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Start,
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            counterText = CounterHelper.processInput(editText)
        }) {
            Text(
                text = "Copy",
                style = TextStyle(
                    fontSize = 26.sp,
                    color = Color.White
                )
            )
        }
    }
}