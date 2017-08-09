package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

public class FeedTemplateNativeAdActivity extends NativeAdActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, FeedTemplateNativeAdActivity.class);
    }

    @Override
    void onItemSelected(final int position) {
        switch (position) {
            case 0:
                openFragment(new FeedTemplateRecyclerAdapterFragmentVertical());
                addLayoutSpinner(new LayoutItemSelectedListener());
                break;
            case 1:
                openFragment(new FeedTemplateBaseAdapterFragment());
                removeLayoutSpinner();
                break;
            case 2:
                openFragment(new FeedTemplateNativeAdFragment());
                removeLayoutSpinner();
                break;
            default:
                throw new IllegalArgumentException("Illegal component position");
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(com.avocarrot.demo.R.string.ad_native_template_feed);
    }

    @Override
    @NonNull
    String[] getComponentSpinnerItems() {
        return getResources().getStringArray(com.avocarrot.demo.R.array.ad_native_feed_components);
    }

    private class LayoutItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
            switch (position) {
                case 0:
                    openFragment(new FeedTemplateRecyclerAdapterFragmentVertical());
                    break;
                case 1:
                    openFragment(new FeedTemplateRecyclerAdapterFragmentHorizontal());
                    break;
                default:
                    throw new IllegalStateException("Unknown position [" + position + "]");
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            //nothing
        }
    }
}
