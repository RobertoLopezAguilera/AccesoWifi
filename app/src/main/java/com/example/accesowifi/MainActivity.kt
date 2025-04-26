package com.example.accesowifi

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Solicitar permiso de ubicación
        val locationPermission = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {}
        locationPermission.launch(Manifest.permission.ACCESS_FINE_LOCATION)

        setContent {
            val wifiViewModel: WifiScanViewModel = viewModel()
            WifiScreen(viewModel = wifiViewModel)
        }
    }
}
