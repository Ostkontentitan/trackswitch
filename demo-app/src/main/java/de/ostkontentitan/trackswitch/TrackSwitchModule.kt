package de.ostkontentitan.trackswitch

import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TrackSwitchModule {

    @Provides
    fun trackSwitcher(@ApplicationContext context: Context): TrackSwitcher {
        val prefs = context.getSharedPreferences("App.FeatureTrain.Preferences", MODE_PRIVATE)
        val builder = TrackSwitcherBuilder()
        builder.addBackend(SharedPreferenceBackend(prefs))
        builder.addBackend(FakeABTestBackend())
        return builder.build()
    }
}