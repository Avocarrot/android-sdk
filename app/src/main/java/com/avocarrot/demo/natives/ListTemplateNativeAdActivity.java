package com.avocarrot.demo.natives;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

public class ListTemplateNativeAdActivity extends NativeAdActivity {

    @NonNull
    public static Intent buildIntent(@NonNull final Context context) {
        return new Intent(context, ListTemplateNativeAdActivity.class);
    }

    @Override
    void onItemSelected(final int position) {
        switch (position) {
            case 0:
                openFragment(new ListTemplateRecyclerAdapterFragmentVertical());
                addLayoutSpinner(new LayoutItemSelectedListener());
                break;
            case 1:
                openFragment(new ListTemplateBaseAdapterFragment());
                removeLayoutSpinner();
                break;
            case 2:
                openFragment(new ListTemplateNativeAdFragment());
                removeLayoutSpinner();
                break;
            default:
                throw new IllegalArgumentException("Illegal component position");
        }
    }

    @Override
    protected String getToolbarTitle() {
        return getString(com.avocarrot.demo.R.string.ad_native_template_list);
    }

    @NonNull
    @Override
    String[] getComponentSpinnerItems() {
        return getResources().getStringArray(com.avocarrot.demo.R.array.ad_native_list_components);
    }

    private class LayoutItemSelectedListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
            switch (position) {
                case 0:
                    openFragment(new ListTemplateRecyclerAdapterFragmentVertical());
                    break;
                case 1:
                    openFragment(new ListTemplateRecyclerAdapterFragmentHorizontal());
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
