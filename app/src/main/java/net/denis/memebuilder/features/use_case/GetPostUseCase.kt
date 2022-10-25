package net.denis.memebuilder.features.use_case

import net.denis.memebuilder.features.model.ResponseData
import net.denis.memebuilder.features.repository.RawPicturesRepository

class GetPostUseCase(
    private val repository: RawPicturesRepository
) {

    suspend operator fun invoke(): List<ResponseData> {
        return repository.getPost()
    }

}