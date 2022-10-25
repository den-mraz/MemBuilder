package net.denis.memebuilder.data.repository

import net.denis.memebuilder.data.remote.GenerateMemeApi
import net.denis.memebuilder.data.remote.dto.PostDto
import net.denis.memebuilder.features.model.ResponseData
import net.denis.memebuilder.features.repository.RawPicturesRepository

class RawPicturesRepositoryImpl(
    private val api: GenerateMemeApi
) : RawPicturesRepository {


    override suspend fun getPost(): List<ResponseData> {
        return api.getPostFromPlaceHolder().map { it.toViewModel() }
    }

}