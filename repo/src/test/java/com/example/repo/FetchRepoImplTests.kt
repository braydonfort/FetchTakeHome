package com.example.repo

import com.example.database.FetchDao
import com.example.database.ItemEntity
import com.example.networking.NetworkDataSource
import com.example.networking.ResponseItem
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.just
import io.mockk.runs
import io.mockk.unmockkAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class FetchRepoImplTests {
    private lateinit var fetchRepo: FetchRepoImpl
    @RelaxedMockK
    private lateinit var networkDataSource: NetworkDataSource
    @RelaxedMockK
    private lateinit var fetchDao: FetchDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        fetchRepo = FetchRepoImpl(networkDataSource, fetchDao)
    }
    @After
    fun teardown(){
        unmockkAll()
    }

    @Test
    fun getAndCacheList_test() = runTest {
        val responseItems = listOf(
            ResponseItem(id = 1, listId = 1, name = "Name1"),
            ResponseItem(id = 2, listId = 2, name = "Name2")
        )
        coEvery { networkDataSource.getItems() } returns responseItems
        coEvery { fetchDao.insertItem(any()) } just runs

        fetchRepo.getAndCahceList()

        coEvery { networkDataSource.getItems() }
        coEvery { fetchDao.insertItem(any()) }
    }

    @Test
    fun getList_test() = runTest {
        // Arrange
        val databaseItems = listOf(
            ItemEntity(id = 1, listId = 1, name = "Name1"),
            ItemEntity(id = 2, listId = 2, name = "Name2")
        )
        coEvery { fetchDao.getItems() } returns databaseItems

        val result = fetchRepo.getList().first()

        assertThat(result.size).isEqualTo(2)
        assertThat(result[0].id).isEqualTo(1)
        assertThat(result[1].id).isEqualTo(2)
    }
}