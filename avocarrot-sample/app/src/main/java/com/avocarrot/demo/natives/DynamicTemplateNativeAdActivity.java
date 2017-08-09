package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

public class DynamicTemplateNativeAdActivity extends NativeAdActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, DynamicTemplateNativeAdActivity.class);
    }

    @Override
    void onItemSelected(final int position) {
        switch (position) {
            case 0:
                openFragment(new DynamicTemplateRecyclerAdapterFragmentVertical());
                addLayoutSpinner(new LayoutItemSelectedListener());
                break;
            case 1:
                openFragment(new DynamicTemplateBaseAdapterFragment());
                removeLayoutSpinner();
                break;
            case 2:
                openFragment(new DynamicTemplateNativeAdFragment());
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
        return getResources().getStringArray(com.avocarrot.demo.R.array.ad_native_dynamic_components);
    }

    private class LayoutItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
            switch (position) {
                case 0:
                    openFragment(new DynamicTemplateRecyclerAdapterFragmentVertical());
                    break;
                case 1:
                    openFragment(new DynamicTemplateRecyclerAdapterFragmentHorizontal());
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
