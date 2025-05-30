package com.example.persona5app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.persona5app.network.Confidant

@Composable
fun Confidant(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Perros del mes", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))

        Text("Golden Retriever", style = MaterialTheme.typography.headlineSmall)
        Image(
            painter = painterResource(id = R.drawable.golden_retriever),
            contentDescription = "Golden Retriever",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Viejo Pastor Inglés", style = MaterialTheme.typography.headlineSmall)
        Image(
            painter = painterResource(id = R.drawable.pastor_ingles),
            contentDescription = "Viejo Pastor Inglés",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Xoloitzcuintle", style = MaterialTheme.typography.headlineSmall)
        Image(
            painter = painterResource(id = R.drawable.xoloitzcuintle),
            contentDescription = "Xoloitzcuintle",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
    }
}