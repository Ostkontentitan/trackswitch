package de.ostkontentitan.trackswitch

class TrackSwitcherBuilder {
    private val backends: MutableMap<BackendType, SwitchBackend> = mutableMapOf()

    fun addBackend(backend: SwitchBackend) {
        backends[backend.type] = backend
    }

    fun build() = TrackSwitcher(backends)
}
