package net.denis.memebuilder.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.spec.NavGraphSpec
import dagger.hilt.android.AndroidEntryPoint
import net.denis.memebuilder.presentation.ViewModel.MainViewModel
import net.denis.memebuilder.presentation.ui.PostItem
import net.denis.memebuilder.presentation.ui.PostScreen
import net.denis.memebuilder.presentation.ui.theme.MemeBuilderTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemeBuilderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm = viewModel<MainViewModel>()

                    val state = vm.state
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

            }

        }
    }

}