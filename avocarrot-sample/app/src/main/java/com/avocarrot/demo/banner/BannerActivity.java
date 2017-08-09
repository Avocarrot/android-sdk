package com.avocarrot.demo.banner;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.avocarrot.demo.AdLifecycleActivity;
import com.avocarrot.demo.MessageUtils;
import com.avocarrot.demo.R;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.banner.BannerAd;
import com.avocarrot.sdk.banner.BannerAdPool;
import com.avocarrot.sdk.banner.listeners.BannerAdCallback;
import com.avocarrot.sdk.mediation.BannerSize;
import com.avocarrot.sdk.mediation.ResponseStatus;

public abstract class BannerActivity extends AdLifecycleActivity implements BannerAdCallback {
    @Nullable
    private BannerAd bannerAd;
    @Nullable
    private CheckBox autoUpdateView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_ad);

        final RelativeLayout bannerView = getBannerView();
        if (bannerView != null) {
            bannerView.setVisibility(View.VISIBLE);

            final String adUnitId = new AdUnitIdStorage(this, AdType.BANNER).getSelectedAdUnitID();

            bannerAd = BannerAdPool.load(this, adUnitId, bannerView, getBannerSize(), this);
            autoUpdateView = (CheckBox) findViewById(R.id.auto_update_switch);
            if (autoUpdateView != null) {
                autoUpdateView.setChecked(bannerAd.isAutoRefreshEnabled());
                autoUpdateView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        bannerAd.setAutoRefreshEnabled(isChecked);
                    }
                });
            }
        }
    }

    @Nullable
    protected abstract RelativeLayout getBannerView();

    @NonNull
    protected abstract BannerSize getBannerSize();

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.ad_type_banner);
    }

    @Override
    protected void initActionBar(@NonNull final ActionBar actionBar) {
        super.initActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (bannerAd != null) {
            bannerAd.onActivityResumed();
            if (autoUpdateView != null) {
                autoUpdateView.setChecked(bannerAd.isAutoRefreshEnabled());
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (bannerAd != null) {
            bannerAd.onActivityPaused();
        }
    }

    @Override
    public void onDestroy() {
        if (bannerAd != null) {
            bannerAd.onActivityDestroyed();
        }
        super.onDestroy();
    }

    @Override
    public void onAdLoaded(@NonNull final BannerAd bannerAd) {
        MessageUtils.showAdLoaded(getApplicationContext());
    }

    @Override
    public void onAdFailed(@NonNull final BannerAd bannerAd, @NonNull ResponseStatus responseStatus) {
        MessageUtils.showAdFailed(getApplicationContext(), responseStatus);
    }

    @Override
    public void onAdOpened(@NonNull final BannerAd bannerAd) {
        MessageUtils.showAdOpened(getApplicationContext());
    }

    @Override
    public void onAdClicked(@NonNull final BannerAd bannerAd) {
        MessageUtils.showAdClicked(getApplicationContext());
    }

    @Override
    public void onAdClosed(@NonNull final BannerAd bannerAd) {
        MessageUtils.showAdClosed(getApplicationContext());
    }
}
