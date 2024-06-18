package com.example.database

import android.content.ClipData.Item
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * dao for database functions
 */
@Dao
interface FetchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemEntity: ItemEntity)

    @Query("SELECT * FROM item_table")
    suspend fun getItems(): List<ItemEntity>
}