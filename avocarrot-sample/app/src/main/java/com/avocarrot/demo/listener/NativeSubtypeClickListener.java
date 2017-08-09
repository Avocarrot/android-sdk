package com.avocarrot.demo.listener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

import com.avocarrot.demo.natives.CustomNativeAdActivity;
import com.avocarrot.demo.natives.DynamicTemplateNativeAdActivity;
import com.avocarrot.demo.natives.FeedTemplateNativeAdActivity;
import com.avocarrot.demo.natives.GridTemplateNativeAdActivity;
import com.avocarrot.demo.natives.ListTemplateNativeAdActivity;

public class NativeSubtypeClickListener extends AdSubtypeClickListener {

    public NativeSubtypeClickListener(@NonNull final Context context) {
        super(context);
    }

    @Override
    public void onItemClick(@NonNull final AdapterView<?> parent, @NonNull final View view, final int position, final long id) {
        switch (position) {
            case 0:
                context.startActivity(ListTemplateNativeAdActivity.buildIntent(context));
                break;
            case 1:
                context.startActivity(FeedTemplateNativeAdActivity.buildIntent(context));
                break;
            case 2:
                context.startActivity(GridTemplateNativeAdActivity.buildIntent(context));
                break;
            case 3:
                context.startActivity(DynamicTemplateNativeAdActivity.buildIntent(context));
                break;
            case 4:
                context.startActivity(CustomNativeAdActivity.buildIntent(context));
                break;
            default:
                throw new IllegalStateException("Unknown position [" + position + "]");
        }
    }
}
