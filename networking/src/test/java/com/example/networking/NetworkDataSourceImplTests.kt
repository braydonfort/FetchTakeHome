package com.example.networking

import com.google.common.base.CharMatcher.any
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.unmockkAll
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class NetworkDataSourceImplTests {

    @RelaxedMockK
    private lateinit var apiService: ApiService

    private lateinit var networkDataSource: NetworkDataSourceImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        networkDataSource = NetworkDataSourceImpl(apiService)
    }

    @After
    fun teardown(){
        unmockkAll()
    }

    @Test
    fun getItems_Successful() = runTest {
        val expectedItems = listOf(ResponseItem(1,1,"name1"), ResponseItem(2,2,"name2"))
        coEvery { apiService.getItems() } returns Response.success(expectedItems)

        val result = networkDataSource.getItems()

        assertThat(expectedItems).isEqualTo(result)

    }

    @Test
    fun getItems_failure() = runTest {
        coEvery { apiService.getItems() } returns Response.error(500, okhttp3.ResponseBody.create(null, ""))
       try {
            networkDataSource.getItems()
       }catch (e: Throwable){
           assertThat(e.message).isEqualTo("Network Exception")
       }

    }
}