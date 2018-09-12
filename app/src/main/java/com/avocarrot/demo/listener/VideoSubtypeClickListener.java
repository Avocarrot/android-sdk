package com.avocarrot.demo.listener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;

import com.avocarrot.demo.video.VideoActivity;

public class VideoSubtypeClickListener extends AdSubtypeClickListener {

    public VideoSubtypeClickListener(@NonNull Context context) {
        super(context);
    }

    @Override
    public void onItemClick(@NonNull final AdapterView<?> parent, @NonNull final View view, final int position, final long id) {
        switch (position) {
            case 0:
                context.startActivity(VideoActivity.buildIntent(context));
                break;
            default:
                throw new IllegalStateException("Unknown position [" + position + "]");
        }
    }
}
