package com.avocarrot.demo.natives;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.avocarrot.demo.R;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.mediation.ResponseStatus;
import com.avocarrot.sdk.nativead.FullscreenNativeAdView;
import com.avocarrot.sdk.nativead.NativeAd;
import com.avocarrot.sdk.nativead.NativeAdPool;

public class FullscreenTemplateNativeAdFragment extends NativeAdCallbackFragment {

    private boolean showOnLoad = false;
    private Button loadButton;
    private Button showButton;
    private Button loadAndShowButton;
    @Nullable
    private NativeAd nativeAd;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();
        nativeAd = NativeAdPool.load(getContext(), adUnitId, FullscreenNativeAdView.BUILDER, null, this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (nativeAd != null) {
            nativeAd.destroy();
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final ViewGroup adContainerView = (ViewGroup) inflater.inflate(R.layout.fragment_native_fullscreen_ad, container, false);
        loadButton = adContainerView.findViewById(R.id.fullscreen_load);
        showButton = adContainerView.findViewById(R.id.fullscreen_show);
        loadAndShowButton = adContainerView.findViewById(R.id.fullscreen_show_on_load);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nativeAd != null) {
                    if (nativeAd.isReady()) {
                        showButton.setEnabled(nativeAd.isReady());
                    } else {
                        nativeAd.reloadAd();
                    }
                }
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nativeAd != null) {
                    renderAdView(nativeAd);
                }
            }
        });
        loadAndShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nativeAd != null) {
                    if (nativeAd.isReady()) {
                        nativeAd.renderAdView();
                    } else {
                        showOnLoad = true;
                        nativeAd.reloadAd();
                    }
                }
            }
        });
        if (nativeAd != null) {
            showButton.setEnabled(nativeAd.isReady());
        }
        return adContainerView;
    }

    protected void renderAdView(@NonNull final NativeAd nativeAd) {
        showOnLoad = false;
        nativeAd.renderAdView();
    }

    @Override
    public void onAdLoaded(@NonNull final NativeAd nativeAd) {
        super.onAdLoaded(nativeAd);
        if (showOnLoad) {
            showOnLoad = false;
            renderAdView(nativeAd);
        } else {
            showButton.setEnabled(nativeAd.isReady());
        }
    }

    @Override
    public void onAdFailed(@NonNull final NativeAd nativeAd, @NonNull final ResponseStatus responseStatus) {
        super.onAdFailed(nativeAd, responseStatus);
        showOnLoad = false;
    }

    @Override
    public void onAdClosed(@NonNull final NativeAd nativeAd) {
        super.onAdClosed(nativeAd);
        showButton.setEnabled(nativeAd.isReady());
    }
}
