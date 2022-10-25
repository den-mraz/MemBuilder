package net.denis.memebuilder.di.modules

import net.denis.memebuilder.features.use_case.GetPostUseCase
import org.koin.dsl.module

val featuresModule = module {

    factory<GetPostUseCase> { GetPostUseCase(repository = get()) }

}