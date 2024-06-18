package com.example.database

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FetchDaoTests {
    private lateinit var database: FetchDatabase
    private lateinit var fetchDao: FetchDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FetchDatabase::class.java
        ).allowMainThreadQueries().build()

        fetchDao = database.fetchDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun testGetandCacheItems() = runTest {
        val item1 = ItemEntity(1,1,"Name1")
        val item2 = ItemEntity(2,2,"Name2")

        fetchDao.insertItem(item1)
        fetchDao.insertItem(item2)

        val cachedItems = fetchDao.getItems()

        assert(cachedItems.size == 2)
        assert(cachedItems.contains(item1).and(cachedItems.contains(item2)))
    }
}