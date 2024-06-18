package com.example.repo

import com.example.database.FetchDao
import com.example.networking.NetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/**
 * Implementation for FetchRepo
 * @see[FetchRepo]
 */

class FetchRepoImpl @Inject constructor(private val networkDataSource: NetworkDataSource, private val fetchDao: FetchDao): FetchRepo {
    override suspend fun getAndCahceList() {
        networkDataSource.getItems().forEach { fetchDao.insertItem(it.toItemEntity()) }
    }

    override suspend fun getList(): Flow<List<RepoItem>> {
        return flowOf(fetchDao.getItems().map { it.toRepoItem() })
    }
}