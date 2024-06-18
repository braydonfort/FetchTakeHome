package com.example.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection for Fetch Repo
 */

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideFetchRepo(fetchRepoImpl: FetchRepoImpl): FetchRepo{
        return fetchRepoImpl
    }
}