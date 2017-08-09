package com.avocarrot.demo.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.avocarrot.demo.AdLifecycleActivity;
import com.avocarrot.demo.MessageUtils;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.interstitial.InterstitialAd;
import com.avocarrot.sdk.interstitial.InterstitialAdPool;
import com.avocarrot.sdk.interstitial.listeners.InterstitialAdCallback;
import com.avocarrot.sdk.mediation.ResponseStatus;


public class InterstitialActivity extends AdLifecycleActivity implements InterstitialAdCallback {
    @Nullable
    private InterstitialAd interstitialAd;
    @Nullable
    private Button showView;

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, InterstitialActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.avocarrot.demo.R.layout.activity_interstitial_ad);

        showView = (Button) findViewById(com.avocarrot.demo.R.id.interstitial_show);
        if (showView != null) {
            showView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (interstitialAd != null) {
                        interstitialAd.showAd();
                        showView.setEnabled(false);
                    }
                }
            });
        }
        findViewById(com.avocarrot.demo.R.id.interstitial_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd != null) {
                    interstitialAd.reloadAd();
                    showView.setEnabled(interstitialAd.isReady());
                }
            }
        });
        findViewById(com.avocarrot.demo.R.id.interstitial_show_on_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd != null) {
                    interstitialAd.reloadAndShowAd();
                    showView.setEnabled(interstitialAd.isReady());
                }
            }
        });
        findViewById(com.avocarrot.demo.R.id.interstitial_delay_show_on_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd != null) {
                    interstitialAd.reloadAndShowAdWithDelay();
                    showView.setEnabled(interstitialAd.isReady());
                }
            }
        });

        final String adUnitId = new AdUnitIdStorage(this, AdType.INTERSTITIAL).getSelectedAdUnitID();

        interstitialAd = InterstitialAdPool.load(this, adUnitId, this);
        if (interstitialAd.isReady() && showView != null) {
            showView.setEnabled(true);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (interstitialAd != null) {
            interstitialAd.onActivityDestroyed();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (interstitialAd != null) {
            interstitialAd.onActivityPaused();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (interstitialAd != null) {
            interstitialAd.onActivityResumed();
            if (interstitialAd.isReady() && showView != null) {
                showView.setEnabled(true);
            }
        }
    }

    @Override
    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
        MessageUtils.showAdLoaded(getApplicationContext());
        if (showView != null) {
            showView.setEnabled(true);
        }
    }

    @Override
    public void onAdFailed(@NonNull InterstitialAd interstitialAd, @NonNull ResponseStatus responseStatus) {
        MessageUtils.showAdFailed(getApplicationContext(), responseStatus);
    }

    @Override
    public void onAdOpened(@NonNull InterstitialAd interstitialAd) {
        MessageUtils.showAdOpened(getApplicationContext());
    }

    @Override
    public void onAdClicked(@NonNull InterstitialAd interstitialAd) {
        MessageUtils.showAdClicked(getApplicationContext());
    }

    @Override
    public void onAdClosed(@NonNull InterstitialAd interstitialAd) {
        MessageUtils.showAdClosed(getApplicationContext());
        if (showView != null) {
            showView.setEnabled(false);
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(com.avocarrot.demo.R.string.ad_type_interstitial);
    }

    @Override
    protected void initActionBar(@NonNull final ActionBar actionBar) {
        super.initActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}
