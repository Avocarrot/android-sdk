package com.avocarrot.demo.natives;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.avocarrot.demo.MessageUtils;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.nativead.NativeAdView;
import com.avocarrot.sdk.nativead.listeners.StreamNativeAdCallback;
import com.avocarrot.sdk.nativead.recyclerview.StreamAdRecyclerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerAdapterFragment extends NativeAdCallbackFragment implements StreamNativeAdCallback {
    protected RecyclerView recyclerView;
    @Nullable
    private StreamAdRecyclerAdapter adAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final ViewGroup contentView = (FrameLayout) inflater.inflate(com.avocarrot.demo.R.layout.fragment_recycler_adapter_ad, container, false);
        recyclerView = (RecyclerView) contentView.findViewById(com.avocarrot.demo.R.id.list);
        return contentView;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                final Context context = getContext();
                if (recyclerView != null && context != null) {
                    recyclerView.setLayoutManager(getLayoutManager(context));
                    final MainAdapter adapter = getAdapter(recyclerView);
                    adAdapter = new StreamAdRecyclerAdapter.Builder()
                            .setAdapter(adapter)
                            .setAdUnitId(adUnitId)
                            .setAdViewBuilder(getNativeAdViewBuilder(), getNativeAdViewAttributes())
                            .setStreamNativeAdCallback(RecyclerAdapterFragment.this)
                            .build(context);
                    recyclerView.setAdapter(adAdapter);
                    adAdapter.loadAd();
                }
            }
        });
    }

    @NonNull
    protected abstract RecyclerView.LayoutManager getLayoutManager(@NonNull final Context context);

    @NonNull
    protected abstract MainAdapter getAdapter(@NonNull final RecyclerView recyclerView);

    @NonNull
    protected abstract NativeAdView.Builder getNativeAdViewBuilder();

    @Nullable
    protected NativeAdView.Attributes getNativeAdViewAttributes() {
        return null;
    }

    @Override
    public void onStreamAdLoadFailed() {
        MessageUtils.showMsg(getContext(), com.avocarrot.demo.R.string.ad_error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (adAdapter != null) {
            adAdapter.destroy();
        }
    }

    protected static final class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
        private static final int SIZE = 50;
        @NonNull
        private final List<String> dataSet;
        private final int width;
        private final int height;

        protected MainAdapter(@NonNull final Context context) {
            dataSet = Collections.unmodifiableList(build(context));
            width = 0;
            height = 0;
        }

        protected MainAdapter(@NonNull final Context context, final int width, final int height) {
            dataSet = Collections.unmodifiableList(build(context));
            this.width = width;
            this.height = height;
        }

        @NonNull
        private static List<String> build(@NonNull final Context context) {
            final List<String> list = new ArrayList<>(SIZE);
            for (int i = 0; i < SIZE; ++i) {
                list.add(context.getString(com.avocarrot.demo.R.string.in_feed_item, i));
            }
            return list;
        }

        @NonNull
        @Override
        public MainAdapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            final TextView textView = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            if (width > 0 && height > 0) {
                final ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, height);
                textView.setLayoutParams(params);
            }
            return new ViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
            holder.textView.setText(dataSet.get(position));
        }

        @Override
        public int getItemCount() {
            return dataSet.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            @NonNull
            private final TextView textView;

            ViewHolder(@NonNull final TextView v) {
                super(v);
                textView = v;
            }
        }
    }
}
