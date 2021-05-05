package com.example.mvp.models

data class Products(
    val id: Int?,
    val title: String?,
    val thumbnail: String?
)

object ProductsEntry {
    const val ID = "id"
    const val TITLE = "title"
    const val IMAGE_URL = "thumbnail"
}
