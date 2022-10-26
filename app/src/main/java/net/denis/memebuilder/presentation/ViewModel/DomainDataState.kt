package net.denis.memebuilder.presentation.ViewModel

import net.denis.memebuilder.features.model.DomainData

data class DomainDataState(
    val posts: List<DomainData> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false
)