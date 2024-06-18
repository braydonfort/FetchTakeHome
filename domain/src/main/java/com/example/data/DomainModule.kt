package com.example.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Dependency Injection for Domain Module
 */
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    @Singleton
    fun provideFetchListUseCase(fetchListUseCaseImpl: FetchListUseCaseImpl): FetchListUseCase{
       return fetchListUseCaseImpl
    }
    @Provides
    @Singleton
    fun providesGetListUseCase(getListUseCaseImpl: GetListUseCaseImpl): GetListUseCase{
        return getListUseCaseImpl
    }
}