package com.hso.statemanagementcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hso.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagementComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(


                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    // State Hosting
    var myString = remember {
        mutableStateOf("")
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            SpecialText(string = "Test")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialText(string = "Android")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialTextField(string = myString.value){
                myString.value = it
            }
        }
    }
}

@Composable
fun SpecialText(string: String){
    Text(text = string,
        fontSize = 26.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun SpecialTextField(string: String,function: (String) -> Unit){
    TextField(value = string, onValueChange = function,
    modifier = Modifier.padding(5.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}