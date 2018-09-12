package com.avocarrot.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.avocarrot.sdk.mediation.ResponseStatus;

public final class MessageUtils {

    private MessageUtils() {
    }

    public static void showAdLoaded(@NonNull final Context context) {
        showMsg(context, R.string.ad_loaded);
    }

    public static void showAdFailed(@NonNull final Context context, @NonNull final ResponseStatus responseStatus) {
        showMsg(context, R.string.ad_error, responseStatus.name());
    }

    public static void showAdOpened(@NonNull final Context context) {
        showMsg(context, R.string.ad_showed);
    }

    public static void showAdClicked(@NonNull final Context context) {
        showMsg(context, R.string.ad_clicked);
    }

    public static void showAdClosed(@NonNull final Context context) {
        showMsg(context, R.string.ad_closed);
    }

    public static void showAdCompleted(@NonNull final Context context) {
        showMsg(context, R.string.ad_completed);
    }

    public static void showMsg(@NonNull final Context context, @StringRes final int resId, @Nullable final Object... formatArgs) {
        Toast.makeText(context, context.getString(resId, formatArgs), Toast.LENGTH_LONG).show();
    }
}
