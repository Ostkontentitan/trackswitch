package de.ostkontentitan.trackswitch

sealed class MainScreenState {
    object Loading : MainScreenState()
    data class Ready(val newFeatureEnabled: Boolean, val abVariant: String) : MainScreenState()
}
