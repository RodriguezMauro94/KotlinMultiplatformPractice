package com.maurosergiorodriguez.professionalfeaturesapp.ui.firebase

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirebaseHomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
       Button(onClick = {
           val zero = 0
           val crash = 100/zero
       }) {
           Text("Crash app")
       }
    }
}