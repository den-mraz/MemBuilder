package net.denis.memebuilder.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.rememberSwipeableState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import net.denis.memebuilder.presentation.ViewModel.MainViewModel

@Composable
@Destination(start = true)
fun PostScreen(
    navigator: DestinationsNavigator,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}
