package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

import com.avocarrot.demo.R;

public class GridTemplateNativeAdActivity extends NativeAdActivity {
    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, GridTemplateNativeAdActivity.class);
    }

    @Override
    void onItemSelected(final int position) {
        switch (position) {
            case 0:
                openFragment(new GridTemplateRecyclerAdapterFragmentVertical());
                addLayoutSpinner(new LayoutItemSelectedListener());
                break;
            default:
                throw new IllegalArgumentException("Illegal component position");
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.ad_native_template_grid);
    }

    @NonNull
    @Override
    String[] getComponentSpinnerItems() {
        return getResources().getStringArray(R.array.ad_native_grid_components);
    }

    private class LayoutItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
            switch (position) {
                case 0:
                    openFragment(new GridTemplateRecyclerAdapterFragmentVertical());
                    break;
                case 1:
                    openFragment(new GridTemplateRecyclerAdapterFragmentHorizontal());
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
