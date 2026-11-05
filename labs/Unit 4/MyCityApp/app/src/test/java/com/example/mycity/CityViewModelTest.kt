package com.example.mycity

import androidx.lifecycle.SavedStateHandle
import com.example.mycity.data.CityRepository
import com.example.mycity.ui.CityViewModel
import org.junit.Assert.*
import org.junit.Test

class CityViewModelTest {
    @Test fun favoritesToggleIndependentlyAndRestore() {
        val state = SavedStateHandle()
        val model = CityViewModel(state)
        model.toggleFavorite(1)
        model.toggleFavorite(2)
        model.toggleFavorite(1)
        assertEquals(listOf(2), model.favorites.value)
        val restored = CityViewModel(SavedStateHandle(mapOf("favorites" to state.get<List<Int>>("favorites"))))
        assertEquals(listOf(2), restored.favorites.value)
    }

    @Test fun everyCategoryContainsAtLeastThreeUniquePlaces() {
        assertEquals(CityRepository.places.size, CityRepository.places.map { it.id }.toSet().size)
        CityRepository.categories.forEach { category ->
            assertTrue(CityRepository.inCategory(category).size >= 3)
        }
        assertNull(CityRepository.place(-1))
    }
}
