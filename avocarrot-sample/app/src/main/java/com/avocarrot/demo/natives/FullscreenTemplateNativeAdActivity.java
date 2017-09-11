package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;

import com.avocarrot.demo.AdLifecycleActivity;
import com.avocarrot.demo.R;

public class FullscreenTemplateNativeAdActivity extends AdLifecycleActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, FullscreenTemplateNativeAdActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_fullscreen_ad);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new FullscreenTemplateNativeAdFragment());
        transaction.commit();
    }

    @Override
    protected String getToolbarTitle() {
        return getString(com.avocarrot.demo.R.string.ad_native_template_fullscreen);
    }
}
