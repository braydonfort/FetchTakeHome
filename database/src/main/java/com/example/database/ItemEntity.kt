package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Database entity for items
 */

@Entity(tableName = "item_table")
data class ItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
     val id: Int,
    @ColumnInfo(name ="listId")
     val listId: Int,
    @ColumnInfo(name = "name")
     val name: String?
)