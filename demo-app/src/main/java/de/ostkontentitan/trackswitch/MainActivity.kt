package de.ostkontentitan.trackswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import de.ostkontentitan.trackswitch.ui.theme.TrackswitchTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TrackswitchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        Text("Trackswitch Demo")

                        val state = viewModel.stateFlow.collectAsState()

                        when (val exact = state.value) {
                            MainScreenState.Loading -> {}
                            is MainScreenState.Ready -> {
                                Text(text = "Is new feature enabled: ${exact.newFeatureEnabled}")
                                Text(text = "AB Test variant served: ${exact.abVariant}")
                            }
                        }
                    }
                }
            }
        }
    }
}
