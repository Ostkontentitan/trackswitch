package de.ostkontentitan.trackswitch

interface SwitchBackend {
    val type: BackendType

    suspend fun <T : Track> fetchTrackFor(trackSwitch: TrackSwitch<T>): T
    suspend fun <T : Track> storeActiveTrack(trackSwitch: TrackSwitch<T>, track: T)
}
