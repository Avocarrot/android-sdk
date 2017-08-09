package com.avocarrot.demo.banner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.avocarrot.demo.R;
import com.avocarrot.sdk.mediation.BannerSize;

public class StandardBannerActivity extends BannerActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, StandardBannerActivity.class);
    }

    @Nullable
    @Override
    protected RelativeLayout getBannerView() {
        return (RelativeLayout) findViewById(R.id.banner_view_standard);
    }

    @NonNull
    @Override
    protected BannerSize getBannerSize() {
        return BannerSize.BANNER_SIZE_320x50;
    }
}
