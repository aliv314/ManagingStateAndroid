package com.example.littlelemonlogin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemonlogin.ui.theme.LittleLemonLoginTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}
@Composable
fun LoginScreen(){
    val context = LocalContext.current

    /* Coursera used this as their state management variables.
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    */
    var username by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.littlelemonlogo),
            contentDescription = "Logo Image"
        )
        TextField(
            //Value will display the username value
            value = username,
            /*
            1. Text field takes in new input.
            2. When it changes, the state changes.
            3. When the state changes, the textfield input changes.
             */
            onValueChange = {username = it},
            label = { Text(text = "Username") },
        )
        TextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
        )
        Button(
            onClick = {
                //Simple if with Toast
                if ((username == "Darian") and (password == "littlelemon")){
                    Toast.makeText(context, "Welcome to Little Lemon!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Wrong username or Password", Toast.LENGTH_SHORT).show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            )
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}