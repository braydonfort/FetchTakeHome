package com.example.repo

import kotlinx.coroutines.flow.Flow

/**
 * Repository Interface
 * @see[FetchRepoImpl]
 */
interface FetchRepo {
    suspend fun getAndCahceList()
    suspend fun getList(): Flow<List<RepoItem>>
}