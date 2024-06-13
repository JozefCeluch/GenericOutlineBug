package com.example.genericoutlinebug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.genericoutlinebug.ui.theme.GenericOutlineBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GenericOutlineBugTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        Greeting(
                            modifier = Modifier.background(Color.Gray),
                            name = "I don't have any shape"
                        )
                        Box {
                            Text(text = "If you see me then the item with custom shape is not displayed")
                            Greeting(
                                modifier = Modifier
                                    .clip(GenericOutlineShape(20.dp))
                                    .background(Color.Green),
                                name = "I have a complex Outline.Generic shape"
                            )
                        }
                        Greeting(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Red),
                            name = "I have a simple Rounded Corner shape"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
    ) {
        Text(
            text = "Hello $name!"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GenericOutlineBugTheme {
        Greeting(name = "Android")
    }
}