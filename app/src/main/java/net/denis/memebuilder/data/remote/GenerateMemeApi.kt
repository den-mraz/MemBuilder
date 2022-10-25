package net.denis.memebuilder.data.remote

import net.denis.memebuilder.data.remote.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET


interface GenerateMemeApi {

    //suspend fun createMeme(memeRequestDto: MemeRequestDto): HttpResponse

    @GET("/posts")
    //@Headers("Content-type: application/json")
    suspend fun getPostFromPlaceHolder(): PostDto

}