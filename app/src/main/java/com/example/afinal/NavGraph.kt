package com.example.persona5app.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.persona5app.model.Persona
import com.example.persona5app.ui.screens.*
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("personas") { PersonasListScreen(navController) }
        composable("persona_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: ""
            PersonaDetailScreen(navController, id)
        }
        composable("confidants") { ConfidantsListScreen(navController) }
        composable("confidant_detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            ConfidantDetailScreen(navController, name)
        }
    }
}

interface Persona5Api {
    @GET("todo")
    suspend fun getPersonas(): List<Persona>

    @GET("personas/{id}")
    suspend fun getPersonaDetail(@Path("id") id: String): Persona
}

object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/image/random")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: Persona5Api = retrofit.create(Persona5Api::class.java)
}


class PersonaViewModel : ViewModel() {
    private val _personas = mutableStateOf<List<Persona>>(emptyList())
    val personas: State<List<Persona>> = _personas

    private val _selectedPersona = mutableStateOf<Persona?>(null)
    val selectedPersona: State<Persona?> = _selectedPersona

    init {
        viewModelScope.launch {
            try {
                _personas.value = RetrofitClient.api.getPersonas()
            } catch (e: Exception) {
                // Manejo de error
            }
        }
    }

    fun loadPersonaDetail(id: String) {
        viewModelScope.launch {
            try {
                _selectedPersona.value = RetrofitClient.api.getPersonaDetail(id)
            } catch (e: Exception) {
                // Manejo de error
            }
        }
    }
}

class DogViewModel : ViewModel() {

    private val _imageUrl = MutableStateFlow<String?>(null)
    val imageUrl: StateFlow<String?> = _imageUrl

    init {
        fetchDogImage()
    }

    fun fetchDogImage() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getRandomDogImage()
                _imageUrl.value = response.message
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}