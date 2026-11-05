package com.example.mycity.data

data class Place(val id: Int, val category: String, val name: String, val description: String)

/** Offline sample content, with no dependency on opening hours or live services. */
object CityRepository {
    val places = listOf(
        Place(1, "Parks", "Major's Hill Park", "Explore paths and viewpoints near Parliament Hill and the Ottawa River."),
        Place(2, "Parks", "Lansdowne Park", "Discover public spaces in the Glebe beside the Rideau Canal."),
        Place(3, "Parks", "Mooney's Bay Park", "Enjoy a riverside green space with room for a picnic and outdoor play."),
        Place(4, "Culture", "National Gallery of Canada", "Discover Canadian and international art in a landmark building near the river."),
        Place(5, "Culture", "Canadian Museum of Nature", "Explore exhibits about animals, fossils, and the natural world."),
        Place(6, "Culture", "Canadian War Museum", "Learn about military history through collections and exhibitions."),
        Place(7, "Walks", "Rideau Canal", "Follow the canal paths for a scenic walk through the city."),
        Place(8, "Walks", "ByWard Market", "Explore a historic neighbourhood with market streets and public spaces."),
        Place(9, "Walks", "Dow's Lake", "Take a waterfront walk and enjoy the surrounding gardens.")
    )
    val categories = places.map { it.category }.distinct()
    fun inCategory(category: String) = places.filter { it.category == category }
    fun place(id: Int) = places.firstOrNull { it.id == id }
}
