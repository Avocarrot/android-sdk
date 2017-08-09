package com.avocarrot.demo.natives;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class GridTemplateRecyclerAdapterFragmentHorizontal extends GridTemplateRecyclerAdapterFragment {

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager(@NonNull final Context context) {
        return new GridLayoutManager(context, SPAN_COUNT, LinearLayoutManager.HORIZONTAL, false);
    }
}
