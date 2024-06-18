package com.example.data

import com.example.repo.FetchRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetListUseCaseImpl @Inject constructor(private val fetchRepo: FetchRepo): GetListUseCase {
    override suspend fun execute(): Flow<List<Item>> {
        return fetchRepo.getList().map { list -> list.map { item -> item.toItem() }}
    }

}