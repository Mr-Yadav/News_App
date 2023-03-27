package com.example.again


data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)