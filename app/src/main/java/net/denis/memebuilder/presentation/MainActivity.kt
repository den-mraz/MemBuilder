package net.denis.memebuilder.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.denis.memebuilder.presentation.ViewModel.MainViewModel
import net.denis.memebuilder.presentation.ui.theme.MemeBuilderTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemeBuilderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    println("++++++++++++++++++++++++++++++++++++++++++++++++++")
                    println(vm.resultData)
                    println("--------------------------------------------------")
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