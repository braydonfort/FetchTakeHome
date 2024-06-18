package com.example.data

import com.example.repo.FetchRepo
import com.example.repo.RepoItem
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetItemUseCaseImplTest {
    private lateinit var getListUseCaseImpl: GetListUseCaseImpl

    @RelaxedMockK
    private lateinit var fetchRepo: FetchRepo

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        getListUseCaseImpl = GetListUseCaseImpl(fetchRepo)
    }

    @Test
    fun getListImpl_test() = runTest {
        val expectedList = listOf(
            RepoItem(1,1,"Name1"),
            RepoItem(2,2,"Name2")
        )
        coEvery { fetchRepo.getList() } returns flowOf(expectedList)
        val result = getListUseCaseImpl.execute()
        assertThat(result.first()).isEqualTo(expectedList.map { it.toItem()})

    }
}