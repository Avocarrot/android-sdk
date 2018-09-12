package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;

import com.avocarrot.sdk.nativead.ListNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public class ListTemplateBaseAdapterFragment extends BaseAdapterFragment {

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return ListNativeAdView.BUILDER;
    }
}
