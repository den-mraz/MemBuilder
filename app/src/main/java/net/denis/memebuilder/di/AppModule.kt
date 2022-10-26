package net.denis.memebuilder.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.memebuilder.common.CONST.BASE_URL_JSONPLACEHOLDER
import net.denis.memebuilder.data.remote.GenerateMemeApi
import net.denis.memebuilder.data.repository.RawPicturesRepositoryImpl
import net.denis.memebuilder.features.repository.RawPicturesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        HttpLoggingInterceptor.Level.BODY
        return HttpLoggingInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideNumbersApi(client: OkHttpClient, gson: Gson): GenerateMemeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_JSONPLACEHOLDER)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GenerateMemeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFactRepository(api: GenerateMemeApi): RawPicturesRepository {
        return RawPicturesRepositoryImpl(api)
    }
}