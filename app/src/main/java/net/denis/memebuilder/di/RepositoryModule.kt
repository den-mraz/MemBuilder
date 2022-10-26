package net.denis.memebuilder.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.memebuilder.data.repository.RawPicturesRepositoryImpl
import net.denis.memebuilder.features.repository.RawPicturesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRawPicturesRepository(
        rawPicturesRepositoryImpl: RawPicturesRepositoryImpl
    ): RawPicturesRepository
}