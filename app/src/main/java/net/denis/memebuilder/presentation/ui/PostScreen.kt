package net.denis.memebuilder.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.rememberSwipeableState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import net.denis.memebuilder.presentation.SettingsNavGraph
import net.denis.memebuilder.presentation.ViewModel.MainViewModel

@SettingsNavGraph(start = true)
@Destination
@Composable
fun PostScreen(
    viewModel: MainViewModel
) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.posts.size) { i ->
                val posts = state.posts[i]
                PostItem(
                    post = posts,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            //TODO(): Navigate to galery
                        }
                    )
                if(i<state.posts.size) {
                    Divider(modifier = Modifier.padding(
                        horizontal = 16.dp
                    ))
                }
            }
        }
    }
}
