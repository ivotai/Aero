package com.sanre.data.model

data class Article(
    val attachments: List<Attachment>,
    val category: String,
    val cover: String,
    val objectId: String,
    val pdf: Pdf,
    val publishTime: Long,
    val title: String,
    val type: Int
)

data class Attachment(
    val attachmentId: String,
    val filename: String,
    val url: String
)

data class Pdf(
    val attachmentId: String,
    val filename: String,
    val url: String
)