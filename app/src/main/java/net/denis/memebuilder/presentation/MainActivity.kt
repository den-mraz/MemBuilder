package net.denis.memebuilder.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.denis.memebuilder.data.remote.GenerateMemeApi
import net.denis.memebuilder.presentation.ViewModel.MainViewModel
import net.denis.memebuilder.presentation.ui.theme.MemeBuilderTheme
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    private val searchViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemeBuilderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm = getViewModel<MainViewModel>()
                    vm._resultDataList.observe(this, Observer { data ->
                        data.let {
                            Greeting(text = data.toString())
                        }
                    })
                    Greeting(text = vm.getPostVm())
                    Greeting("END")
                }
            }
        }
    }

}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MemeBuilderTheme {
        Greeting("Android")
    }
}