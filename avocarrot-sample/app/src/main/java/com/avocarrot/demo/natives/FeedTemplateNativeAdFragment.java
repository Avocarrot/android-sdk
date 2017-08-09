package com.avocarrot.demo.natives;

import com.avocarrot.sdk.nativead.FeedNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public class FeedTemplateNativeAdFragment extends NativeAdFragment {

    @Override
    NativeAdView.Builder getNativeAdViewBuilder() {
        return FeedNativeAdView.BUILDER;
    }
}
