package com.example.data

import com.example.repo.FetchRepo
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FetchListUseCaseImplTest {

    private lateinit var fetchListUseCaseImpl: FetchListUseCaseImpl

    @RelaxedMockK
    private lateinit var fetchRepo: FetchRepo

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        fetchListUseCaseImpl = FetchListUseCaseImpl(fetchRepo)
    }

    @Test
    fun fetchListUseCaseImpl_test() = runTest {
        fetchListUseCaseImpl.execute()
        coVerify { fetchRepo.getAndCahceList() }
    }
}