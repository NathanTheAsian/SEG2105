package com.example.mycity.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.mycity.data.CityRepository
import com.example.mycity.data.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(viewModel: CityViewModel = viewModel()) {
    val nav = rememberNavController()
    val entry by nav.currentBackStackEntryAsState()
    val favorites by viewModel.favorites.collectAsState()
    Scaffold(topBar = {
        TopAppBar(title = { Text("Explore Ottawa") }, navigationIcon = {
            if (nav.previousBackStackEntry != null) {
                TextButton(onClick = { nav.navigateUp() }) { Text("Back") }
            }
        })
    }) { padding ->
        BoxWithConstraints(Modifier.fillMaxSize().padding(padding)) {
            val expanded = maxWidth >= 840.dp
            val medium = maxWidth >= 600.dp
            Row(Modifier.fillMaxSize()) {
                if (medium) {
                    NavigationRail {
                        CityRepository.categories.forEach { category ->
                            NavigationRailItem(
                                selected = entry?.arguments?.getString("category") == category,
                                onClick = { nav.navigate("places/$category") { popUpTo("categories"); launchSingleTop = true } },
                                icon = { Text(category.take(1)) },
                                label = { Text(category) }
                            )
                        }
                    }
                }
                NavHost(nav, startDestination = "categories", modifier = Modifier.weight(1f)) {
                    composable("categories") {
                        LazyColumn(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            item { Text("Discover your city", style = MaterialTheme.typography.headlineMedium) }
                            items(CityRepository.categories) { category ->
                                OutlinedButton(onClick = { nav.navigate("places/$category") }, modifier = Modifier.fillMaxWidth()) { Text(category) }
                            }
                        }
                    }
                    composable("places/{category}", arguments = listOf(navArgument("category") { type = NavType.StringType })) { route ->
                        val category = route.arguments?.getString("category").orEmpty()
                        PlaceBrowser(category, null, expanded, favorites, viewModel::toggleFavorite) { nav.navigate("place/$category/$it") }
                    }
                    composable("place/{category}/{id}", arguments = listOf(
                        navArgument("category") { type = NavType.StringType },
                        navArgument("id") { type = NavType.IntType }
                    )) { route ->
                        val category = route.arguments?.getString("category").orEmpty()
                        val place = CityRepository.place(route.arguments?.getInt("id") ?: -1)
                        if (expanded) {
                            PlaceBrowser(category, place, true, favorites, viewModel::toggleFavorite) {
                                nav.navigate("place/$category/$it") { popUpTo("places/$category"); launchSingleTop = true }
                            }
                        } else if (place != null) {
                            PlaceDetails(place, place.id in favorites, { viewModel.toggleFavorite(place.id) }, Modifier.fillMaxSize())
                        } else { Text("Place unavailable") }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlaceBrowser(category: String, selected: Place?, expanded: Boolean, favorites: List<Int>, toggle: (Int) -> Unit, open: (Int) -> Unit) {
    val places = CityRepository.inCategory(category)
    Row(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.weight(1f).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            item { Text(category, style = MaterialTheme.typography.headlineMedium) }
            items(places, key = { it.id }) { place ->
                OutlinedButton(onClick = { open(place.id) }, modifier = Modifier.fillMaxWidth()) {
                    Text(place.name + if (place.id in favorites) " ★" else "")
                }
            }
        }
        if (expanded) {
            val current = selected ?: places.firstOrNull()
            if (current != null) PlaceDetails(current, current.id in favorites, { toggle(current.id) }, Modifier.weight(1.4f))
        }
    }
}

@Composable
private fun PlaceDetails(place: Place, favorite: Boolean, toggle: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState()).padding(24.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(place.category, style = MaterialTheme.typography.labelLarge)
        Text(place.name, style = MaterialTheme.typography.headlineLarge)
        Text(place.description, style = MaterialTheme.typography.bodyLarge)
        Button(onClick = toggle) { Text(if (favorite) "Remove from favorites" else "Save to favorites") }
    }
}
