package com.example.apiterremotos

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(value = "significant_month.geojson")
    suspend fun getSignificantByMonth() : Response<FeatureCollection>

    @GET(value = "all_week.geojson")
    suspend fun getAllByWeek() : Response<FeatureCollection>
}