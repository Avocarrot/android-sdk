package com.avocarrot.demo.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.avocarrot.demo.R;

public class ImagePagerAdapter extends PagerAdapter {
    @NonNull
    private final Context context;
    @NonNull
    private final int[] items;
    @NonNull
    private final String[] names;

    public ImagePagerAdapter(@NonNull final Context context, @NonNull final int[] items, @NonNull final String[] names) {
        this.context = context;
        this.items = items.clone();
        this.names = names.clone();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final ImageView image = (ImageView) LayoutInflater.from(context).inflate(R.layout.carousel_ad_item, container, false);
        image.setImageResource(items[position]);
        container.addView(image);
        return image;
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return names[position];
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return (view == object);
    }
}
