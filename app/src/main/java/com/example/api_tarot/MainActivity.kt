package com.example.api_tarot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.api_tarot.ui.TarotScreen
import com.example.api_tarot.ui.theme.Api_TarotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Api_TarotTheme {
                Api_TarotApp()
            }
        }
    }
}

@Composable
fun Api_TarotApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        TarotScreen(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Api_TarotAppPreview() {
    Api_TarotTheme {
        TarotScreen()
    }
}