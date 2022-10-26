package net.denis.memebuilder.features.repository

import kotlinx.coroutines.flow.Flow
import net.denis.memebuilder.common.Resource
import net.denis.memebuilder.data.remote.dto.PostDto
import net.denis.memebuilder.features.model.DomainData

interface RawPicturesRepository {
    suspend fun getPost(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<DomainData>>>
}