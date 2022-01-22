package de.ostkontentitan.trackswitch

class FakeABTestBackend : SwitchBackend {
    override val type: BackendType = Type

    override suspend fun <T : Track> fetchTrackFor(trackSwitch: TrackSwitch<T>): T {
        // TODO interact with AB Testing Framework
        return trackSwitch.tracks.random()
    }

    override suspend fun <T : Track> storeActiveTrack(trackSwitch: TrackSwitch<T>, track: T) {
        // TODO interact with AB Testing Framework
    }

    companion object {
        val Type = BackendType("App.FakeABTestBackend")
    }
}
