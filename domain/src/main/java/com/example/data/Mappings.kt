package com.example.data

import com.example.repo.RepoItem

/**
 * Mappings file for domain module
 */
fun RepoItem.toItem(): Item{
    return Item(id, listId, name)
}