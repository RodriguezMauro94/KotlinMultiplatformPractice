package com.maurosergiorodriguez.professionalfeaturesapp.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.maurosergiorodriguez.professionalfeaturesapp.ui.core.navigation.Routes
import org.jetbrains.compose.resources.painterResource
import professionalfeaturesapp.composeapp.generated.resources.Res
import professionalfeaturesapp.composeapp.generated.resources.ic_logo_google

@Composable
fun LoginScreen(mainNavController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Professional Features MVP", fontSize = 32.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))

        Button(onClick = {
            mainNavController.navigate(Routes.Home.route)
        }) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(Res.drawable.ic_logo_google),
                contentDescription = "")
            Text("Sign in with Google")
        }

        OutlinedButton(onClick = {
            mainNavController.navigate(Routes.Firestore.route)
        }) {
            Text("Enter App")
        }
    }
}