package net.denis.memebuilder.features.repository

import net.denis.memebuilder.data.remote.dto.PostDto

interface RawPicturesRepository {
    suspend fun getPost(): PostDto
}