package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab04.ui.Navigation
import com.example.lab04.ui.theme.AppTheme
import com.example.lab04.ui.viewmodel.SessionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val app = applicationContext as DemoDataApp
            val sessionVm: SessionViewModel = viewModel(
                factory = SessionViewModel.Factory(app.sessionManager)
            )

            val isDarkModePref by sessionVm.isDarkMode.collectAsState()
            val usarModoOscuro = isDarkModePref ?: isSystemInDarkTheme()

            AppTheme(darkTheme = usarModoOscuro, dynamicColor = false) {
                Navigation()
            }
        }
    }
}