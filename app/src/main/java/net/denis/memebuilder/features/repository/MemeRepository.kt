package net.denis.memebuilder.features.repository

interface MemeRepository {

    suspend fun getMeme(): Long

}