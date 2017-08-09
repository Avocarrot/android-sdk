package com.avocarrot.demo.listener;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.AdapterView;

abstract class AdSubtypeClickListener implements AdapterView.OnItemClickListener {
    final Context context;

    AdSubtypeClickListener(@NonNull final Context context) {
        this.context = context;
    }
}
