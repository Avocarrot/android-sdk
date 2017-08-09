package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;

import com.avocarrot.sdk.nativead.FeedNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public class FeedTemplateBaseAdapterFragment extends BaseAdapterFragment {

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return FeedNativeAdView.BUILDER;
    }
}
