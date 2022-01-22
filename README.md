# trackswitch
An Android library to manage feature switches with different backends. 

Configure a TrackSwitcher instance for your app.


        val prefs = context.getSharedPreferences("App.FeatureTrain.Preferences", MODE_PRIVATE)
        val builder = TrackSwitcherBuilder()
        builder.addBackend(SharedPreferenceBackend(prefs))
        builder.addBackend(FakeABTestBackend())
        val trackSwitcher = builder.build()

Configure your feature flag.

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

Check the selected track where you need it. 
``
val abTestVariant = trackSwitcher.getTrackFor(TestVariantsSwitch)
``

Change the backend within 1 single single line going from local flags to ab testing or firebase remote. 

Roadmap:

* tests
* add default backends
* add configurable error handler
* add 'override' backend option for test/debug builds
* add convenience to retrieval (esp. for boolean)
* add test examples
* publish library