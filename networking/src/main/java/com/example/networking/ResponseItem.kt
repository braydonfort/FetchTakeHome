package com.example.networking

/**
 * Data Class for item returned by network call
 */
data class ResponseItem(
     val id: Int,
     val listId: Int,
     val name: String?
)
