package com.avocarrot.demo.natives;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.avocarrot.sdk.nativead.ListNativeAdView;
import com.avocarrot.sdk.nativead.NativeAdView;

public abstract class ListTemplateRecyclerAdapterFragment extends RecyclerAdapterFragment {

    @NonNull
    @Override
    protected MainAdapter getAdapter(@NonNull final RecyclerView recyclerView) {
        return new MainAdapter(getContext());
    }

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return ListNativeAdView.BUILDER;
    }
}
