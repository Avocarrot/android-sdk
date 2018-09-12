package com.avocarrot.demo.natives;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.avocarrot.demo.MessageUtils;
import com.avocarrot.demo.R;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.StreamAdBaseAdapter;
import com.avocarrot.sdk.nativead.listeners.StreamNativeAdCallback;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapterFragment extends NativeAdCallbackFragment implements StreamNativeAdCallback {

    @Nullable
    private StreamAdBaseAdapter adAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final ViewGroup contentView = (FrameLayout) inflater.inflate(R.layout.fragment_base_adapter_ad, container, false);
        final ListView listView = (ListView) contentView.findViewById(R.id.list);
        final Context context = getContext();
        final MainAdapter adapter = new MainAdapter(context);
        final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();

        adAdapter = new StreamAdBaseAdapter.Builder()
                .setAdapter(adapter)
                .setAdUnitId(adUnitId)
                .setViewBuilder(getNativeAdViewBuilder())
                .setAdViewAttributes(new NativeAdView.Attributes()
                        .setStarRating(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.StarRating>() {
                            @Override
                            public NativeAdView.Attributes.StarRating set(@NonNull NativeAdView.Attributes.StarRating starRating) {
                                return starRating.setStarRatingStyle(NativeAdView.Attributes.StarRating.Style.MEDIUM);
                            }
                        })
                        .setAdAttribution(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.AdAttribution>() {
                            @Override
                            public NativeAdView.Attributes.AdAttribution set(@NonNull NativeAdView.Attributes.AdAttribution adAttribution) {
                                return adAttribution.setDefaultText(R.string.ad_attribution_text);
                            }
                        })
                        .setCallToAction(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.CallToAction>() {
                            @Override
                            public NativeAdView.Attributes.CallToAction set(@NonNull NativeAdView.Attributes.CallToAction callToAction) {
                                return callToAction
                                        .setDefaultText(R.string.call_to_action_text);
                            }
                        })
                )
                .setNativeAdCallback(this)
                .build(context);
        listView.setAdapter(adAdapter);
        adAdapter.loadAd();
        return contentView;
    }

    @Override
    public void onStreamAdLoadFailed() {
        MessageUtils.showMsg(getContext(), R.string.ad_error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (adAdapter != null) {
            adAdapter.destroy();
        }
    }

    @NonNull
    protected abstract NativeAdView.Builder getNativeAdViewBuilder();

    private static final class MainAdapter extends ArrayAdapter<String> {
        private static final int SIZE = 30;

        private MainAdapter(@NonNull final Context context) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1, build(context));
        }

        @NonNull
        private static List<String> build(@NonNull final Context context) {
            final List<String> list = new ArrayList<>(SIZE);
            for (int i = 0; i < SIZE; ++i) {
                list.add(context.getString(R.string.in_feed_item, i));
            }
            return list;
        }
    }
}
