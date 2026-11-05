package com.example.mycity.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

/** Navigation owns the selected route; this ViewModel owns user preferences. */
class CityViewModel(private val savedState: SavedStateHandle) : ViewModel() {
    val favorites: StateFlow<List<Int>> = savedState.getStateFlow("favorites", emptyList())
    fun toggleFavorite(id: Int) {
        savedState["favorites"] = favorites.value.let {
            if (id in it) it - id else it + id
        }
    }
}
