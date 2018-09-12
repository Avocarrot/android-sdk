package com.avocarrot.demo.natives;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DynamicTemplateRecyclerAdapterFragmentVertical extends DynamicTemplateRecyclerAdapterFragment {

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager(@NonNull final Context context) {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }
}
