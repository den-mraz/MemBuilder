package net.denis.memebuilder.features.use_case

import net.denis.memebuilder.data.remote.dto.PostDto
import net.denis.memebuilder.features.repository.RawPicturesRepository

class GetPostUseCase(
    private val repository: RawPicturesRepository
) {

    suspend operator fun invoke(): PostDto {
        return repository.getPost()
    }

}