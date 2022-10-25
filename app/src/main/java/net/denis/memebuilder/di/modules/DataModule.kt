package net.denis.memebuilder.di.modules

import net.denis.memebuilder.data.repository.RawPicturesRepositoryImpl
import net.denis.memebuilder.features.repository.RawPicturesRepository
import net.denis.memebuilder.features.use_case.GetPostUseCase
import org.koin.dsl.module

val dataModule = module {

    single<RawPicturesRepository> {
        RawPicturesRepositoryImpl(api = get())
    }

}