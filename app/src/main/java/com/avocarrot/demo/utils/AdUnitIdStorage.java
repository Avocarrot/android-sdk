package com.avocarrot.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AdUnitIdStorage {
    @NonNull
    private final SharedPreferences preferences;
    @NonNull
    private final Set<String> adUnitIdsSet;
    @NonNull
    private final AdType adType;

    public AdUnitIdStorage(@NonNull final Context context, @NonNull final AdType adType) {
        this.adType = adType;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        adUnitIdsSet = readAdUnits();
    }

    public void addAdUnitId(@NonNull final String adUnitId) {
        if (adUnitIdsSet.contains(adUnitId)) {
            return;
        }
        adUnitIdsSet.add(adUnitId);
        saveAdUnitIds();
    }

    public boolean removeAdUnitId(@NonNull final String adUnitId) {
        if (Arrays.asList(adType.defaultAdUnitIds).contains(adUnitId)) {
            return false;
        }
        final boolean removed = adUnitIdsSet.remove(adUnitId);
        saveAdUnitIds();
        return removed;
    }

    @NonNull
    public String getSelectedAdUnitID() {
        return preferences.getString(adType + "_selected_ad_unit", adType.defaultAdUnitIds[0]);
    }

    @NonNull
    public Collection<String> getAdUnitIds() {
        return adUnitIdsSet;
    }

    public void setSelectedAdUnitId(@NonNull final String adUnitId) {
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(adType + "_selected_ad_unit", adUnitId);
        editor.apply();
    }

    @NonNull
    private Set<String> readAdUnits() {
        Set<String> adUnitsSet = new HashSet<>();
        final String jsonString = preferences.getString(adType + "_ad_units_json", null);
        if (jsonString != null) {
            adUnitsSet = new Gson().fromJson(jsonString, new TypeToken<Set<String>>() {
            }.getType());
        } else {
            adUnitsSet.addAll(Arrays.asList(adType.defaultAdUnitIds));
        }
        return adUnitsSet;
    }

    private void saveAdUnitIds() {
        final String jsonArray = new Gson().toJson(adUnitIdsSet);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(adType + "_ad_units_json", jsonArray);
        editor.apply();
    }
}
