package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.avocarrot.demo.R;

public class CustomNativeAdActivity extends NativeAdActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, CustomNativeAdActivity.class);
    }

    @Override
    void onItemSelected(final int position) {
        switch (position) {
            case 0:
                openFragment(new CustomNativeAdFragment());
                break;
            case 1:
                openFragment(new CustomRecyclerAdapterFragment());
                break;
            case 2:
                openFragment(new CustomBaseAdapterFragment());
                break;
            case 3:
                openFragment(new NativeAssetsFragment());
                break;
            case 4:
                openFragment(new ViewPagerFragment());
                break;
            default:
                throw new IllegalArgumentException("Illegal component position");
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.ad_native_template_custom);
    }

    @NonNull
    @Override
    String[] getComponentSpinnerItems() {
        return getResources().getStringArray(R.array.ad_native_custom_components);
    }
}
