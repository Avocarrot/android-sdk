package com.avocarrot.demo.video;

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
import com.avocarrot.sdk.mediation.ResponseStatus;
import com.avocarrot.sdk.video.VideoAd;
import com.avocarrot.sdk.video.VideoAdPool;
import com.avocarrot.sdk.video.listeners.VideoAdCallback;

public class VideoActivity extends AdLifecycleActivity implements VideoAdCallback {
    @Nullable
    private VideoAd videoAd;
    private Button showView;

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, VideoActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.avocarrot.demo.R.layout.activity_video_ad);

        showView = (Button) findViewById(com.avocarrot.demo.R.id.video_show);
        showView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoAd != null) {
                    videoAd.showAd();
                    showView.setEnabled(videoAd.isReady());
                }
            }
        });
        findViewById(com.avocarrot.demo.R.id.video_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoAd != null) {
                    videoAd.reloadAd();
                    showView.setEnabled(videoAd.isReady());
                }
            }
        });
        findViewById(com.avocarrot.demo.R.id.video_show_on_load).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoAd != null) {
                    videoAd.reloadAndShowAd();
                    showView.setEnabled(videoAd.isReady());
                }
            }
        });

        final String adUnitId = new AdUnitIdStorage(this, AdType.VIDEO).getSelectedAdUnitID();

        videoAd = VideoAdPool.load(this, adUnitId, true, this);
        showView.setEnabled(videoAd.isReady());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (videoAd != null) {
            videoAd.onActivityResumed();
            showView.setEnabled(videoAd.isReady());
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (videoAd != null) {
            videoAd.onActivityPaused();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (videoAd != null) {
            videoAd.onActivityDestroyed();
        }
    }

    @Override
    public void onAdLoaded(@NonNull final VideoAd videoAd) {
        MessageUtils.showAdLoaded(getApplicationContext());
        showView.setEnabled(true);
    }

    @Override
    public void onAdFailed(@NonNull final VideoAd videoAd, @NonNull final ResponseStatus responseStatus) {
        MessageUtils.showAdFailed(getApplicationContext(), responseStatus);
    }

    @Override
    public void onAdOpened(@NonNull final VideoAd videoAd) {
        MessageUtils.showAdOpened(getApplicationContext());
    }

    @Override
    public void onAdClicked(@NonNull final VideoAd videoAd) {
        MessageUtils.showAdClicked(getApplicationContext());
    }

    @Override
    public void onAdClosed(@NonNull final VideoAd videoAd) {
        MessageUtils.showAdClosed(getApplicationContext());
        showView.setEnabled(false);
    }

    @Override
    public void onAdCompleted(@NonNull final VideoAd videoAd) {
        MessageUtils.showAdCompleted(getApplicationContext());
    }

    @Override
    protected String getToolbarTitle() {
        return getString(com.avocarrot.demo.R.string.ad_type_video);
    }

    @Override
    protected void initActionBar(@NonNull final ActionBar actionBar) {
        super.initActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }
}
