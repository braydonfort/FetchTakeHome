package com.example.data

/**
 * Interface for fetching the list of items
 * @see[FetchListUseCaseImpl]
 */
interface FetchListUseCase {
    suspend fun execute()
}