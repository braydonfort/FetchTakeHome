package com.example.networking

import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface for endpoints
 */

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): Response<List<ResponseItem>>
}