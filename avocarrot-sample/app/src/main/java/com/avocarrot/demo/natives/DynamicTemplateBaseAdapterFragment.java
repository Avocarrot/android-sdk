package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;

import com.avocarrot.sdk.nativead.FeedNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.json2view.DynamicNativeAdView;

public class DynamicTemplateBaseAdapterFragment extends BaseAdapterFragment {

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return DynamicNativeAdView.BUILDER;
    }
}
