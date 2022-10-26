package net.denis.memebuilder.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.memebuilder.common.Resource
import net.denis.memebuilder.data.remote.GenerateMemeApi
import net.denis.memebuilder.data.remote.dto.PostDto
import net.denis.memebuilder.features.model.DomainData
import net.denis.memebuilder.features.repository.RawPicturesRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RawPicturesRepositoryImpl @Inject constructor(
    private val api: GenerateMemeApi
) : RawPicturesRepository {

    override suspend fun getPost(
        fetchFromRemote: Boolean
    ): Flow<Resource<List<DomainData>>> {
        return flow {
            emit(Resource.LOADING(true))
            val remoteListings = try {

                val response = api.getPostFromPlaceHolder()
                response.map { it.toDomainData() }

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.ERROR("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.ERROR("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                emit(Resource.SUCCESS(listings))
                emit(Resource.LOADING(false))

            }
        }
    }

}