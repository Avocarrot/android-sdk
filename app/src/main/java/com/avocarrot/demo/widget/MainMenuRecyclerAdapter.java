package com.avocarrot.demo.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainMenuRecyclerAdapter extends RecyclerView.Adapter<MainMenuRecyclerAdapter.ViewHolder> {

    @NonNull
    private final List<String> data = new ArrayList<>();
    @Nullable
    private OnItemClickListener listener;

    public void setData(@Nullable final Collection<String> data) {
        this.data.clear();
        if (data != null) {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addItem(@Nullable final String item) {
        this.data.add(item);
        notifyDataSetChanged();
    }

    @Nullable
    public String getItem(final int position) {
        return data.get(position);
    }

    public void removeItem(final int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener(@Nullable final OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final TextView textView = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String item = data.get(position);
        holder.textView.setText(item);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {
        void onItemClick(@Nullable final String item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        private final TextView textView;

        ViewHolder(@NonNull final TextView v) {
            super(v);
            textView = v;
        }
    }
}
