package com.example.data

import com.example.repo.FetchRepo
import javax.inject.Inject

/**
 * Implementation Class for FetchListUsecase
 * @see[FetchListUseCase]
 */
class FetchListUseCaseImpl @Inject constructor(private val fetchRepo: FetchRepo): FetchListUseCase {
    override suspend fun execute() {
        fetchRepo.getAndCahceList()
    }
}