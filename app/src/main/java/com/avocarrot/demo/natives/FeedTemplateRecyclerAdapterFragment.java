package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.avocarrot.sdk.nativead.FeedNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public abstract class FeedTemplateRecyclerAdapterFragment extends RecyclerAdapterFragment {

    @NonNull
    @Override
    protected MainAdapter getAdapter(@NonNull final RecyclerView recyclerView) {
        return new MainAdapter(recyclerView.getContext());
    }

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return FeedNativeAdView.BUILDER;
    }
}
