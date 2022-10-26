package net.denis.memebuilder.presentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.denis.memebuilder.common.Resource
import net.denis.memebuilder.features.model.DomainData
import net.denis.memebuilder.features.repository.RawPicturesRepository
import net.denis.memebuilder.features.use_case.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: RawPicturesRepository
) : ViewModel() {

    var state by mutableStateOf(DomainDataState())

    private var searchJob: Job? = null

    fun onEvent(event: PostListEvent) {
        when (event) {
            is PostListEvent.Refresh -> {
                getPostListing(fetchFromRemote = true)
            }
        }
    }

    private fun getPostListing(
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getPost(fetchFromRemote)
                .collect { result ->
                    when (result) {
                        is Resource.SUCCESS -> {
                            result.data?.let { listings ->
                                state = state.copy(
                                    posts = listings
                                )
                            }
                        }
                        is Resource.ERROR -> Unit
                        is Resource.LOADING -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }

}