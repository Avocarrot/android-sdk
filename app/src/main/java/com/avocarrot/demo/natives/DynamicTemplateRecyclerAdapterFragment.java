package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.json2view.DynamicNativeAdView;

public abstract class DynamicTemplateRecyclerAdapterFragment extends RecyclerAdapterFragment {

    @NonNull
    @Override
    protected MainAdapter getAdapter(@NonNull final RecyclerView recyclerView) {
        return new MainAdapter(recyclerView.getContext());
    }

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
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
