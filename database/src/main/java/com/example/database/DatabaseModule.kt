package com.example.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection for database and dao
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FetchDatabase {
        return Room.databaseBuilder(context, FetchDatabase::class.java, "fetch_database").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: FetchDatabase): FetchDao {
        return db.fetchDao()
    }
}