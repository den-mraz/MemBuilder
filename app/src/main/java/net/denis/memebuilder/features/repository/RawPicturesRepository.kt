package net.denis.memebuilder.features.repository

import net.denis.memebuilder.features.model.ResponseData

interface RawPicturesRepository {
    suspend fun getPost(): List<ResponseData>
}