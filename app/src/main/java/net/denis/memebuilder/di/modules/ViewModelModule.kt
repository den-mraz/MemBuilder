package net.denis.memebuilder.di.modules

import net.denis.memebuilder.presentation.ViewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MainViewModel(getPostUseCase = get())
    }

}