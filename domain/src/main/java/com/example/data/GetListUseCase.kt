package com.example.data

import kotlinx.coroutines.flow.Flow

/**
 * Interface for Getting the List of Items
 */
interface GetListUseCase {
    suspend fun execute():Flow<List<Item>>
}