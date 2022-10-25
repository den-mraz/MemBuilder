package net.denis.memebuilder.di.modules

import net.denis.memebuilder.data.repository.RawPicturesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory {
        RawPicturesRepositoryImpl(api = get())
    }

}