package com.avocarrot.demo.banner;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.avocarrot.demo.R;
import com.avocarrot.sdk.mediation.BannerSize;

public class MrecBannerActivity extends BannerActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, MrecBannerActivity.class);
    }

    @Nullable
    @Override
    protected RelativeLayout getBannerView() {
        return (RelativeLayout) findViewById(R.id.banner_view_mrec);
    }

    @NonNull
    @Override
    protected BannerSize getBannerSize() {
        return BannerSize.BANNER_SIZE_300x250;
    }
}
