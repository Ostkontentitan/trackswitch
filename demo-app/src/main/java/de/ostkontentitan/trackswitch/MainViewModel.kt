package de.ostkontentitan.trackswitch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val trackSwitcher: TrackSwitcher) : ViewModel() {

    private val _stateFlow = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val stateFlow: StateFlow<MainScreenState> = _stateFlow

    init {
        viewModelScope.launch {
            val abTestVariant = trackSwitcher.getTrackFor(TestVariantsSwitch)
            _stateFlow.emit(MainScreenState.Ready(false, abTestVariant.key))
        }
    }
}
