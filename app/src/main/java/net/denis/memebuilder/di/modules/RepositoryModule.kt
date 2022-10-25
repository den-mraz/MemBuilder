package net.denis.memebuilder.di.modules

import net.denis.memebuilder.data.repository.RawPicturesRepositoryImpl
import net.denis.memebuilder.features.repository.RawPicturesRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<RawPicturesRepository> {
        RawPicturesRepositoryImpl(api = get())
    }

}