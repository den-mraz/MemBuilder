package net.denis.memebuilder.data.remote.dto

import net.denis.memebuilder.features.model.ResponseData

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
){
    fun toViewModel(): ResponseData = ResponseData (
        titleTest = title,
        bodyTest = body
    )
}