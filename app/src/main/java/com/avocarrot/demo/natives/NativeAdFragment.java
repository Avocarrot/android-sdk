package com.avocarrot.demo.natives;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.avocarrot.demo.R;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.nativead.NativeAd;
import com.avocarrot.sdk.nativead.NativeAdPool;
import com.avocarrot.sdk.nativead.NativeAdView;

public abstract class NativeAdFragment extends NativeAdCallbackFragment {
    @Nullable
    private ViewGroup adContainerView;
    @Nullable
    protected NativeAd nativeAd;

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (adContainerView != null) {
            final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();
            nativeAd = NativeAdPool.load(getContext(), adUnitId, getNativeAdViewBuilder(), getNativeAdViewAttributes(), this);
        }
    }

    @Nullable
    protected NativeAdView.Attributes getNativeAdViewAttributes() {
        return null;
    }

    abstract NativeAdView.Builder getNativeAdViewBuilder();

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        adContainerView = inflateContainerView(inflater, container);
        return adContainerView;
    }

    protected ViewGroup inflateContainerView(final LayoutInflater inflater, final ViewGroup container) {
        return (ViewGroup) inflater.inflate(R.layout.fragment_native_ad, container, false);
    }

    @Override
    public void onAdLoaded(@NonNull final NativeAd nativeAd) {
        super.onAdLoaded(nativeAd);
        renderAdView(nativeAd);
    }

    protected void renderAdView(@NonNull final NativeAd nativeAd) {
        final View nativeView = nativeAd.renderAdView();
        if (adContainerView != null && nativeView != null) {
            adContainerView.removeAllViews();
            adContainerView.setVisibility(View.VISIBLE);
            adContainerView.addView(nativeView);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }
}
