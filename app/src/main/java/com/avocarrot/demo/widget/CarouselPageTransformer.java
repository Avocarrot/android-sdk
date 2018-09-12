package com.avocarrot.demo.widget;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.view.View;

public class CarouselPageTransformer implements ViewPager.PageTransformer {

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public void transformPage(final View view, final float position) {
        final ViewPager viewPager = (ViewPager) view.getParent();

        final int leftInScreen = view.getLeft() - viewPager.getScrollX();
        final int centerXInViewPager = leftInScreen + view.getMeasuredWidth() / 2;
        final int offsetX = centerXInViewPager - viewPager.getMeasuredWidth() / 2;
        final float offsetRate = offsetX * 0.38F / (float) viewPager.getMeasuredWidth();
        final float scaleFactor = 1 - 1.5F * Math.abs(offsetRate);
        final float alphaFactor = 1 - 3.0F * Math.abs(offsetRate);
        if (scaleFactor > 0) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setAlpha(alphaFactor);
            final float density = view.getResources().getDisplayMetrics().density;
            view.setTranslationX(-180 * density * offsetRate);
        }
    }
}
