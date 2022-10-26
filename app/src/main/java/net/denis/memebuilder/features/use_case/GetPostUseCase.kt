package net.denis.memebuilder.features.use_case

import net.denis.memebuilder.features.model.DomainData
import net.denis.memebuilder.features.repository.RawPicturesRepository

class GetPostUseCase(
    private val repository: RawPicturesRepository
) {

//    suspend operator fun invoke(): List<ResponseData> {
//        return repository.getPost()
//    }
//    suspend operator fun invoke(): List<DomainData> {
//        return repository.getPost()
//    }

}