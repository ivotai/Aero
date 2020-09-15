package com.sanre.data.model

data class Page<T>(
    val content: List<T>,
    val totalElements: String
)

