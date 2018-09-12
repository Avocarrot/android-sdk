package com.avocarrot.demo.utils;

import android.support.annotation.NonNull;

public enum AdType {
    BANNER(
            "3dfbb889-3bcd-4c34-82ae-8fcb539c3b25"
    ),
    INTERSTITIAL(
            "6b34bf0e-04c4-47f9-b4d3-caeddeab0b13"
    ),
    VIDEO(
            "032c0809-0335-4e98-8f8c-8e522f291d0f"
    ),
    NATIVE(
            "e5cc8e6d-d674-402a-aeca-eda7856bd7af"
    );

    @NonNull
    public final String[] defaultAdUnitIds;

    AdType(@NonNull final String... defaultAdUnitIds) {
        this.defaultAdUnitIds = defaultAdUnitIds;
    }
}
