package de.ostkontentitan.trackswitch

import java.lang.IllegalStateException

class TrackSwitcher(
    private val backends: MutableMap<BackendType, SwitchBackend>
) {

    suspend fun <T : Track> getTrackFor(switch: TrackSwitch<T>): T {
        return (
            backends[switch.backend]?.fetchTrackFor(switch)
                ?: throw IllegalStateException("BackendType ${switch.backend} not installed.")
            )
    }
}
