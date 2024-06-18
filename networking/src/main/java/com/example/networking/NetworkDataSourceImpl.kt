package com.example.networking

import javax.inject.Inject

/**
 * Implementation for Network Data Source
 * @see[NetworkDataSource]
 * @param[ApiService]
 */
class NetworkDataSourceImpl @Inject constructor(private val apiService: ApiService): NetworkDataSource {
    override suspend fun getItems(): List<ResponseItem> {
        val response = apiService.getItems()
        if (response.isSuccessful){
            println("Body: ${response.body().toString()}")
            return response.body()!!
        } else {
            throw Exception("Network Exception")
        }
    }
}