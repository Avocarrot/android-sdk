package com.avocarrot.demo.natives;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.avocarrot.demo.R;
import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.listeners.StreamNativeAdCallback;

public class CustomRecyclerAdapterFragment extends RecyclerAdapterFragment implements StreamNativeAdCallback {

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager(@NonNull final Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    @NonNull
    @Override
    protected MainAdapter getAdapter(@NonNull RecyclerView recyclerView) {
        return new MainAdapter(getContext());
    }

    @NonNull
    @Override
    protected NativeAdView.Builder getNativeAdViewBuilder() {
        return new NativeAdView.Builder() {
            @NonNull
            @Override
            public NativeAdView createAdView(@NonNull final Context context, @Nullable final ViewGroup viewGroup) {
                final NativeAdView adView = (NativeAdView) LayoutInflater.from(context).inflate(R.layout.widget_native_ad_custom, viewGroup, false);
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
        };
    }
}
