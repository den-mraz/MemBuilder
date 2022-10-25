package net.denis.memebuilder.presentation.ViewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.denis.memebuilder.data.remote.dto.PostDto
import net.denis.memebuilder.features.use_case.GetPostUseCase

class MainViewModel(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    private val _resultData = MutableLiveData<PostDto>()
    val resultData: LiveData<PostDto> = _resultData

    init {
        getPostVm()
    }

    private fun getPostVm() {
        viewModelScope.launch {
            _resultData.value = getPostUseCase()
        }
    }

}