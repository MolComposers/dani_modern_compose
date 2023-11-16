package com.example.modernprograming_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.modernprograming_jetpackcompose.ui.theme.ModernPrograming_JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernPrograming_JetpackComposeTheme {
                Surface() {
                    
                }
            }
        }
    }
}