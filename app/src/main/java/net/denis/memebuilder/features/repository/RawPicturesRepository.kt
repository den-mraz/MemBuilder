package net.denis.memebuilder.features.repository

interface RawPicturesRepository {

    suspend fun getRawPicture() : Long

}