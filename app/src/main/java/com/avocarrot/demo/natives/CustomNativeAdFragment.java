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

public class CustomNativeAdFragment extends NativeAdCallbackFragment {
    @Nullable
    private FrameLayout adContainerView;
    @Nullable
    private NativeAd nativeAd;

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (adContainerView != null) {
            final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();
            nativeAd = NativeAdPool.load(getContext(), adUnitId, this);
        }
    }

    @NonNull
    private NativeAdView getCustomNativeAdView() {
        final NativeAdView adView = (NativeAdView) LayoutInflater.from(getContext()).inflate(R.layout.widget_native_ad_custom, adContainerView, false);
        adView.setIconView(R.id.native_ad_icon);
        adView.setCoverImageView(R.id.native_ad_image);
        adView.setTextView(R.id.native_ad_text);
        adView.setTitleView(R.id.native_ad_title);
        adView.setCallToActionView(R.id.native_ad_call_to_action);
        adView.setStarRatingView(R.id.native_ad_star_rating);
        adView.setAdChoiceIconView(R.id.native_ad_choices_icon);
        adView.setAdAttributionView(R.id.native_ad_attribution);
        return adView;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        adContainerView = (FrameLayout) inflater.inflate(R.layout.fragment_native_ad, container, false);
        return adContainerView;
    }

    @Override
    public void onAdLoaded(@NonNull final NativeAd nativeAd) {
        super.onAdLoaded(nativeAd);
        final NativeAdView adView = getCustomNativeAdView();
        nativeAd.renderAdView(adView);
        if (adContainerView != null) {
            adContainerView.removeAllViews();
            adContainerView.setVisibility(View.VISIBLE);
            adContainerView.addView(adView);
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
