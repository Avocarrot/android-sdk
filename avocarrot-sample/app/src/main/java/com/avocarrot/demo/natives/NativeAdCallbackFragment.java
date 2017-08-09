package com.avocarrot.demo.natives;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.avocarrot.demo.MessageUtils;
import com.avocarrot.sdk.mediation.ResponseStatus;
import com.avocarrot.sdk.nativead.NativeAd;
import com.avocarrot.sdk.nativead.listeners.NativeAdCallback;

public abstract class NativeAdCallbackFragment extends Fragment implements NativeAdCallback {

    @Override
    public void onAdLoaded(@NonNull final NativeAd nativeAd) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdLoaded(context);
        }
    }

    @Override
    public void onAdFailed(@NonNull final NativeAd nativeAd, @NonNull ResponseStatus responseStatus) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdFailed(context, responseStatus);
        }
    }

    @Override
    public void onAdOpened(@NonNull final NativeAd nativeAd) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdOpened(context);
        }
    }

    @Override
    public void onAdClicked(@NonNull final NativeAd nativeAd) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdClicked(context);
        }
    }

    @Override
    public void onAdClosed(@NonNull final NativeAd nativeAd) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdClosed(context);
        }
    }

    @Override
    public void onAdCompleted(@NonNull final NativeAd nativeAd) {
        final Context context = getContext();
        if (context != null) {
            MessageUtils.showAdCompleted(context);
        }
    }
}
