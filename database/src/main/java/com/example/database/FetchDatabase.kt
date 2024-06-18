package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database
 */

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
abstract class FetchDatabase: RoomDatabase() {
    abstract fun fetchDao(): FetchDao
}