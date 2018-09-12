package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.avocarrot.sdk.nativead.GridNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public abstract class GridTemplateRecyclerAdapterFragment extends RecyclerAdapterFragment {
    public static final int SPAN_COUNT = 2;

    @NonNull
    @Override
    protected MainAdapter getAdapter(@NonNull final RecyclerView recyclerView) {
        final int size = recyclerView.getMeasuredWidth() / SPAN_COUNT;
        return new MainAdapter(recyclerView.getContext(), size, size);
    }

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return GridNativeAdView.BUILDER;
    }
}
