package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.json2view.DynamicNativeAdView;

public class DynamicTemplateNativeAdFragment extends NativeAdFragment {

    @Override
    NativeAdView.Builder getNativeAdViewBuilder() {
        return DynamicNativeAdView.BUILDER;
    }

    @Nullable
    @Override
    protected NativeAdView.Attributes getNativeAdViewAttributes() {
        return new NativeAdView.Attributes().setStarRating(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.StarRating>() {
            @Override
            public NativeAdView.Attributes.StarRating set(@NonNull NativeAdView.Attributes.StarRating starRating) {
                return starRating.setStarRatingStyle(NativeAdView.Attributes.StarRating.Style.MEDIUM);
            }
        });
    }
}
