package com.example.apiterremotos

data class FeatureCollection (
    val metadata: Metadata,
    val features: List<Feature>
)

data class Metadata (
    val title: String,
)

data class Feature (
    val properties: Properties,
    val geometry: Geometry,
    val id: String
)

data class Geometry (
    val coordinates: List<Double>
)
data class Properties (
    val mag: Double,
    val place: String,
    val time: Long
)