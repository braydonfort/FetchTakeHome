package com.example.repo

import com.example.database.ItemEntity
import com.example.networking.ResponseItem

/**
 * Mapping functions for converting between different Item data classes
 */

fun ItemEntity.toRepoItem(): RepoItem {
    return RepoItem(id, listId, name)
}
fun ResponseItem.toRepoItem():RepoItem{
    return RepoItem(id, listId, name)
}
fun ResponseItem.toItemEntity(): ItemEntity{
    return ItemEntity(id, listId, name)
}