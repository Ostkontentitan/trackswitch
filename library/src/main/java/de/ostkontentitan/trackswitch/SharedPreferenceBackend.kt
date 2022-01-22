package de.ostkontentitan.trackswitch

import android.content.SharedPreferences

class SharedPreferenceBackend(
    private val sharedPreferences: SharedPreferences
) : SwitchBackend {
    override val type: BackendType = BackendType("TrackSwitch.SharedPreferenceBackend")

    override suspend fun <T : Track> fetchTrackFor(trackSwitch: TrackSwitch<T>): T {
        val stringValue = sharedPreferences.getString(trackSwitch.key, trackSwitch.default.key)!!
        return trackSwitch.tracks.first { it.key == stringValue }
    }

    override suspend fun <T : Track> storeActiveTrack(
        trackSwitch: TrackSwitch<T>,
        track: T
    ) {
        sharedPreferences.edit().apply()
    }

    companion object {
        val Type = BackendType("TrackSwitch.SharedPreferenceBackend")
    }
}
