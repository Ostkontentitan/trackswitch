package de.ostkontentitan.trackswitch

interface TrackSwitch<T : Track> {
    val key: String
    val backend: BackendType
    val tracks: Array<T>
    val default: T
}
