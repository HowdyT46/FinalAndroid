package com.example.persona5app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Bienvenido a Persona 5 Compendium", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("personas") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Personas")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("confidants") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Confidants")
        }
    }
}
