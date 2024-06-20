package com.example.myrecipeapp.ui.theme
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainviewModel :ViewModel(){
    private val categoryState= mutableStateOf(RecipeState())
    val categoriesState:State<RecipeState> = categoryState

    init {
        fetchCategories()
    }


    private fun fetchCategories(){
        viewModelScope.launch {
            try {
                 val response= recipeService.getCategories()
                categoryState.value=categoryState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            } catch (e:Exception){
                categoryState.value=categoryState.value.copy(
                    loading = false,
                    error = "Error fetching category ${e.message}"
                )

            }
        }
    }


    data class RecipeState(
        val loading:Boolean=true,
        val list: List<Category> = emptyList(),
        val error:String? =null

    )
}