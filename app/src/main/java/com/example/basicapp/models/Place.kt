package com.example.basicapp.models

data class Place(
    val id: String,
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val reviews: Int,
    val price: Double,
    val description: String,
    val location: String,
    val facilities: List<String> = listOf()
)