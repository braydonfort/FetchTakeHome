package com.example.networking

import retrofit2.Response

/**
 * Interface for network data source network calls
 * @see[NetworkDataSourceImpl]
 */
interface NetworkDataSource {
    suspend fun getItems(): List<ResponseItem>
}