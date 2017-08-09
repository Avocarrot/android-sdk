package com.avocarrot.demo.natives;

import com.avocarrot.sdk.nativead.ListNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public class ListTemplateNativeAdFragment extends NativeAdFragment {

    @Override
    NativeAdView.Builder getNativeAdViewBuilder() {
        return ListNativeAdView.BUILDER;
    }
}
