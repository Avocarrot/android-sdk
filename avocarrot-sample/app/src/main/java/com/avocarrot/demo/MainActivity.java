package com.avocarrot.demo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.avocarrot.demo.listener.BannerSubtypeClickListener;
import com.avocarrot.demo.listener.InterstitialSubtypeClickListener;
import com.avocarrot.demo.listener.NativeSubtypeClickListener;
import com.avocarrot.demo.listener.OnTouchClickListener;
import com.avocarrot.demo.listener.VideoSubtypeClickListener;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.demo.widget.CarouselPageTransformer;
import com.avocarrot.demo.widget.ImagePagerAdapter;
import com.avocarrot.demo.widget.MainMenuRecyclerAdapter;
import com.avocarrot.sdk.Avocarrot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AdLifecycleActivity implements ViewPager.OnPageChangeListener {
    @NonNull
    private static final Pattern AD_UNIT_ID_PATTERN = Pattern.compile("^[a-f0-9]{8}\\-[a-f0-9]{4}\\-[a-f0-9]{4}\\-[a-f0-9]{4}\\-[a-f0-9]{12}$");
    @NonNull
    private static final int[] AD_TYPES = {R.drawable.icon_banner_ad, R.drawable.icon_interstitial_ad, R.drawable.icon_video_ad, R.drawable.icon_native_ad};
    @NonNull
    private final List<String> names = new ArrayList<>();

    private ArrayAdapter<String> mainAdapter;
    private ListView adSubtypeListView;
    private FloatingActionButton editAdUnitButton;
    private TextView currentAdUnitIdTextView;
    private EditText editView;
    private AdType adType;
    private MainMenuRecyclerAdapter adUnitIdAdapter;
    private BottomSheetBehavior<LinearLayout> bottomSheetBehavior;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Avocarrot.setDebugMode(true);
        Avocarrot.setTestMode(true);
        setContentView(R.layout.activity_main);

        editAdUnitButton = findViewById(R.id.fab_adunit_id);
        currentAdUnitIdTextView = findViewById(R.id.current_ad_unit_id);
        RecyclerView adUnitIdListView = findViewById(R.id.adunitid_list);
        adUnitIdAdapter = new MainMenuRecyclerAdapter();

        final TabLayout tabLayout = findViewById(R.id.tabs);
        final ViewPager pager = findViewById(R.id.viewpager);
        final LinearLayout adUnitBottomSheet = findViewById(R.id.bottom_sheet);
        final Toolbar toolbar = findViewById(R.id.toolbar);

        tabLayout.setupWithViewPager(pager);
        pager.setClipChildren(false);
        pager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        pager.setOffscreenPageLimit(3);
        pager.setPageTransformer(false, new CarouselPageTransformer());
        final ImagePagerAdapter adapter = new ImagePagerAdapter(this, AD_TYPES, getResources().getStringArray(R.array.ad_types));
        pager.setAdapter(adapter);

        adSubtypeListView = findViewById(R.id.ad_subtype_list);
        mainAdapter = new MainAdapter(this, names);
        adSubtypeListView.setAdapter(mainAdapter);
        pager.addOnPageChangeListener(this);
        pager.setCurrentItem(0);
        pager.setOnTouchListener(new OnTouchClickListener() {
            @Override
            public void onClick(View view, MotionEvent motionEvent) {
                final int position = pager.getCurrentItem();
                if (position > 0 && motionEvent.getX() <= pager.getWidth() / 3F) {
                    pager.setCurrentItem(position - 1);
                } else if (position < adapter.getCount() - 1 && motionEvent.getX() > 2 * pager.getWidth() / 3F) {
                    pager.setCurrentItem(position + 1);
                }
            }
        });

        names.addAll(Arrays.asList(getResources().getStringArray(R.array.ad_banner_subtypes)));
        mainAdapter.notifyDataSetChanged();
        adSubtypeListView.setOnItemClickListener(new BannerSubtypeClickListener(MainActivity.this));
        adUnitIdListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adUnitIdListView.setAdapter(adUnitIdAdapter);
        adUnitIdListView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        setAdType(AdType.BANNER);

        bottomSheetBehavior = BottomSheetBehavior.from(adUnitBottomSheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull final View bottomSheet, final int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    editAdUnitButton.setVisibility(View.GONE);
                }
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    editView.clearFocus();
                    hideKeyboard();
                }
                if (newState != BottomSheetBehavior.STATE_EXPANDED) {
                    if (editAdUnitButton.getVisibility() != View.VISIBLE) {
                        editAdUnitButton.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    editAdUnitButton.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
                }
            }
        });

        adUnitBottomSheet.post(new Runnable() {
            @Override
            public void run() {
                adUnitBottomSheet.getLayoutParams().height = findViewById(android.R.id.content).getMeasuredHeight()
                        - toolbar.getMeasuredHeight();
                adUnitBottomSheet.requestLayout();
                bottomSheetBehavior.onLayoutChild((CoordinatorLayout) findViewById(R.id.coordinator_layout), adUnitBottomSheet,
                        ViewCompat.LAYOUT_DIRECTION_LTR);
            }
        });

        editAdUnitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.adunitid_input_layout);
        editView = findViewById(R.id.adunitid_value_edit);
        editView.addTextChangedListener(new TextWatcherAdapter() {
            @Override
            public void afterTextChanged(Editable s) {
                textInputLayout.setError(null);
            }
        });

        final ImageButton saveView = findViewById(R.id.adunitid_save);
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final String newAdUnitId = editView.getText().toString().trim();
                if (TextUtils.isEmpty(newAdUnitId) || !AD_UNIT_ID_PATTERN.matcher(newAdUnitId).matches()) {
                    textInputLayout.setError(getString(R.string.wrond_adunitid));
                    return;
                }
                editView.setText(null);
                final AdUnitIdStorage adUnitIdStorage = new AdUnitIdStorage(MainActivity.this, adType);
                if (adUnitIdStorage.getAdUnitIds().contains(newAdUnitId)) {
                    adUnitIdStorage.setSelectedAdUnitId(newAdUnitId);
                    return;
                }
                adUnitIdStorage.addAdUnitId(newAdUnitId);
                adUnitIdStorage.setSelectedAdUnitId(newAdUnitId);
                currentAdUnitIdTextView.setText(newAdUnitId);
                adUnitIdAdapter.addItem(newAdUnitId);
            }
        });

        adUnitIdAdapter.setOnItemClickListener(new MainMenuRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(@Nullable String adUnitId) {
                if (adUnitId != null) {
                    final AdUnitIdStorage adUnitIdStorage = new AdUnitIdStorage(MainActivity.this, adType);
                    adUnitIdStorage.setSelectedAdUnitId(adUnitId);
                    currentAdUnitIdTextView.setText(adUnitId);
                    editView.clearFocus();
                    hideKeyboard();
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                  final RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, final int swipeDir) {
                final int position = viewHolder.getAdapterPosition();
                final AdUnitIdStorage adUnitIdStorage = new AdUnitIdStorage(MainActivity.this, adType);
                final String adUnitId = adUnitIdAdapter.getItem(position);
                if (TextUtils.isEmpty(adUnitId) || Arrays.asList(adType.defaultAdUnitIds).contains(adUnitId)) {
                    adUnitIdAdapter.notifyDataSetChanged();
                    return;
                }
                if (adUnitIdStorage.getSelectedAdUnitID().equals(adUnitId)) {
                    final int nextPosition;
                    if (position + 1 < adUnitIdAdapter.getItemCount()) {
                        nextPosition = position + 1;
                    } else {
                        if (position - 1 >= 0) {
                            nextPosition = position - 1;
                        } else {
                            adUnitIdAdapter.notifyDataSetChanged();
                            return;
                        }
                    }

                    final String nextAdUnitId = adUnitIdAdapter.getItem(nextPosition);
                    if (!TextUtils.isEmpty(nextAdUnitId)) {
                        adUnitIdStorage.setSelectedAdUnitId(nextAdUnitId);
                        currentAdUnitIdTextView.setText(nextAdUnitId);
                    } else {
                        adUnitIdAdapter.notifyDataSetChanged();
                        return;
                    }
                }
                adUnitIdStorage.removeAdUnitId(adUnitId);
                adUnitIdAdapter.removeItem(position);
            }
        };

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(adUnitIdListView);
    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        //nothing
    }

    @Override
    public void onPageSelected(final int position) {
        names.clear();
        final List<String> subtypes;
        final AdapterView.OnItemClickListener onItemClickListener;
        switch (position) {
            case 0:
                setAdType(AdType.BANNER);
                subtypes = Arrays.asList(getResources().getStringArray(R.array.ad_banner_subtypes));
                onItemClickListener = new BannerSubtypeClickListener(MainActivity.this);
                break;
            case 1:
                setAdType(AdType.INTERSTITIAL);
                subtypes = Collections.singletonList(getString(R.string.ad_type_interstitial));
                onItemClickListener = new InterstitialSubtypeClickListener(MainActivity.this);
                break;
            case 2:
                setAdType(AdType.VIDEO);
                subtypes = Collections.singletonList(getString(R.string.ad_type_video));
                onItemClickListener = new VideoSubtypeClickListener(MainActivity.this);
                break;
            case 3:
                setAdType(AdType.NATIVE);
                subtypes = Arrays.asList(getResources().getStringArray(R.array.ad_native_templates));
                onItemClickListener = new NativeSubtypeClickListener(MainActivity.this);
                break;
            default:
                throw new IllegalArgumentException("Wrong pager position");
        }
        names.addAll(subtypes);
        mainAdapter.notifyDataSetChanged();
        adSubtypeListView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        //nothing
    }

    private void hideKeyboard() {
        final View view = getCurrentFocus();
        if (view != null) {
            final InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void setAdType(@NonNull final AdType adType) {
        this.adType = adType;
        final AdUnitIdStorage adUnitIdStorage = new AdUnitIdStorage(this, adType);
        currentAdUnitIdTextView.setText(adUnitIdStorage.getSelectedAdUnitID());
        adUnitIdAdapter.setData(new ArrayList<>(adUnitIdStorage.getAdUnitIds()));
    }

    @Override
    protected String getToolbarTitle() {
        return getString(R.string.app_name);
    }

    private static class MainAdapter extends ArrayAdapter<String> {
        private MainAdapter(@NonNull final Context context, final List<String> names) {
            super(context, android.R.layout.simple_list_item_1, android.R.id.text1, names);
        }
    }

    @Override
    public void onBackPressed() {
        if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            editAdUnitButton.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    private static class TextWatcherAdapter implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    }
}
