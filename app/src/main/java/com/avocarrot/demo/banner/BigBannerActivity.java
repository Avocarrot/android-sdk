package com.avocarrot.demo.banner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.avocarrot.sdk.mediation.BannerSize;

public class BigBannerActivity extends BannerActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, BigBannerActivity.class);
    }

    @Nullable
    protected RelativeLayout getBannerView() {
        return (RelativeLayout) findViewById(com.avocarrot.demo.R.id.banner_view_big);
    }

    @NonNull
    protected BannerSize getBannerSize() {
        return BannerSize.BANNER_SIZE_728x90;
    }
}
