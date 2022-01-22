# trackswitch
An Android library to manage feature switches with different backends. 

Configure a TrackSwitcher and add it to your graph
``
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
``

Configure your feature flag
``
object TestVariantsSwitch : TrackSwitch<TestVariantsSwitch.Variant> {
    override val key: String = "enable_new_feature"
    override val backend: BackendType = SharedPreferenceBackend.Type
    override val default: Variant = Variant.VARIANT_B
    override val tracks: Array<Variant> = Variant.values()

    enum class Variant(override val key: String) : Track {
        VARIANT_A("ab_test_variant_a"),
        VARIANT_B("ab_test_variant_b"),
        VARIANT_C("ab_test_variant_c")
    }
}
``

Check the selected track
``
val abTestVariant = trackSwitcher.getTrackFor(TestVariantsSwitch)
``

Roadmap:
- tests
- add default backends
- add configurable error handler
- add 'override' backend option for test/debug builds
- add convenience to retrieval (esp. for boolean)
- add test examples
- publish library