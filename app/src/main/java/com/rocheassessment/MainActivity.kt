package com.rocheassessment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.remember
import dagger.hilt.android.AndroidEntryPoint
import com.rocheassessment.navigation.AppNavHost
import com.rocheassessment.ui.auth.AuthViewModel
import com.rocheassessment.ui.theme.AppTheme


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val authViewModel by viewModels<AuthViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                content = {
                    AppTheme {
                        AppNavHost(authViewModel)
                     //   InventoryApp()
                    }
                }
            )
        }
    }

}