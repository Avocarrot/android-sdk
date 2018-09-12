package com.avocarrot.demo.natives;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.avocarrot.demo.AdLifecycleActivity;
import com.avocarrot.demo.R;

public abstract class NativeAdActivity extends AdLifecycleActivity implements AdapterView.OnItemSelectedListener {

    protected AppCompatSpinner layoutSpinner;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_ad);

        layoutSpinner = findViewById(R.id.layout_spinner);
        final ArrayAdapter<String> layoutAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.layout_orientation));
        layoutSpinner.setAdapter(layoutAdapter);
        layoutAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final AppCompatSpinner componentSpinner = findViewById(R.id.component_spinner);
        final ArrayAdapter<String> componentAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, getComponentSpinnerItems());
        componentSpinner.setAdapter(componentAdapter);
        componentAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        componentSpinner.setOnItemSelectedListener(this);
        componentSpinner.setSelection(0);
    }

    @Override
    protected void initActionBar(@NonNull final ActionBar actionBar) {
        super.initActionBar(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
        onItemSelected(position);
    }

    @Override
    public void onNothingSelected(final AdapterView<?> parent) {
        //empty
    }

    protected void openFragment(@NonNull final Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    protected void removeLayoutSpinner() {
        layoutSpinner.setVisibility(View.INVISIBLE);
        layoutSpinner.setOnItemSelectedListener(null);
    }

    protected void addLayoutSpinner(@NonNull final AdapterView.OnItemSelectedListener onItemClickListener) {
        layoutSpinner.setOnItemSelectedListener(onItemClickListener);
        layoutSpinner.setVisibility(View.VISIBLE);
    }

    abstract void onItemSelected(final int position);

    @NonNull
    abstract String[] getComponentSpinnerItems();
}
