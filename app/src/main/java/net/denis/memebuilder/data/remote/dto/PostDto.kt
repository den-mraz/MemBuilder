package net.denis.memebuilder.data.remote.dto

import net.denis.memebuilder.features.model.DomainData

data class PostDto(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) {
    fun toDomainData(): DomainData = DomainData(
        titleTest = title,
        bodyTest = body
    )

    fun PostDto.toDomainDataExt(): DomainData {
        return DomainData(
            titleTest = title,
            bodyTest = body

        )
    }

}