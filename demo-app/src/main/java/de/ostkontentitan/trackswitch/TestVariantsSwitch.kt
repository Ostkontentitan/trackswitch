package de.ostkontentitan.trackswitch

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
