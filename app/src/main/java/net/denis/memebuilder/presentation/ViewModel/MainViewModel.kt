package net.denis.memebuilder.presentation.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import net.denis.memebuilder.features.model.ResponseData
import net.denis.memebuilder.features.use_case.GetPostUseCase

class MainViewModel(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    val _resultDataList: MutableLiveData<List<ResponseData>> = MutableLiveData()

    fun getPostVm() {
        viewModelScope.launch {
            _resultDataList.value = getPostUseCase()
        }
    }

}