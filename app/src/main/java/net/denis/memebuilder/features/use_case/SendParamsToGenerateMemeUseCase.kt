package net.denis.memebuilder.features.use_case

import net.denis.memebuilder.features.repository.RawPicturesRepository

class SendParamsToGenerateMemeUseCase(
    private val rawPicturesRepository: RawPicturesRepository) {
//
//    suspend operator fun invoke(
//        topText: String,
//        bottomText: String,
//        image: String,
//    ) {
//        rawPicturesRepository.sendParamForCreateMeme(topText = topText, bottomText = bottomText, imageLink = image)
//    }
}