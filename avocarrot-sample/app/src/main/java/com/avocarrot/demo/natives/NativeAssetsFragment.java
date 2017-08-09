package com.avocarrot.demo.natives;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.avocarrot.demo.MessageUtils;
import com.avocarrot.demo.R;
import com.avocarrot.demo.utils.AdType;
import com.avocarrot.demo.utils.AdUnitIdStorage;
import com.avocarrot.sdk.mediation.ResponseStatus;
import com.avocarrot.sdk.nativeassets.NativeAssetsAd;
import com.avocarrot.sdk.nativeassets.NativeAssetsAdPool;
import com.avocarrot.sdk.nativeassets.NativeAssetsConfig;
import com.avocarrot.sdk.nativeassets.listeners.NativeAssetsAdCallback;
import com.avocarrot.sdk.nativeassets.model.AdChoice;
import com.avocarrot.sdk.nativeassets.model.Image;
import com.avocarrot.sdk.nativeassets.model.NativeAssets;
import com.avocarrot.sdk.nativeassets.model.Rating;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class NativeAssetsFragment extends Fragment implements NativeAssetsAdCallback {
    @Nullable
    private NativeAssetsAd nativeAssetsAd;
    @Nullable
    private LinearLayout adContainer;
    @Nullable
    private TextView title;
    @Nullable
    private TextView body;
    @Nullable
    private TextView adChoiceText;
    @Nullable
    private TextView cta;
    @Nullable
    private ImageView icon;
    @Nullable
    private ImageView image;
    @Nullable
    private ImageView adChoiceIcon;
    @Nullable
    private RatingBar rating;

    private static void renderImageView(@NonNull final ImageView view, final Image image) {
        if (image != null) {
            view.setVisibility(View.VISIBLE);
            view.setAdjustViewBounds(true);
            final int width = image.getWidth();
            final int height = image.getHeight();
            if ((width > 0) && (height > 0)) {
                view.setMaxWidth(width);
                view.setMaxHeight(height);
            }
            view.setImageDrawable(image.getDrawable());
        } else {
            view.setImageDrawable(null);
            view.setVisibility(GONE);
        }
    }

    private static void renderRatingBarView(@NonNull final RatingBar view, @Nullable final Rating starRating) {
        view.setStepSize(0.1F);
        view.setIsIndicator(true);
        if (starRating != null) {
            view.setNumStars((int) starRating.getScale());
            view.setRating((float) starRating.getValue());
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(GONE);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final LinearLayout containerView = (LinearLayout) inflater.inflate(R.layout.fragment_native_assets_ad, container, false);
        adContainer = (LinearLayout) containerView.findViewById(R.id.native_assets_ad_container);
        title = (TextView) containerView.findViewById(R.id.native_assets_ad_title);
        body = (TextView) containerView.findViewById(R.id.native_assets_ad_body);
        adChoiceText = (TextView) containerView.findViewById(R.id.native_assets_ad_choices_caption);
        cta = (TextView) containerView.findViewById(R.id.native_assets_ad_call_to_action);
        icon = (ImageView) containerView.findViewById(R.id.native_assets_ad_icon);
        image = (ImageView) containerView.findViewById(R.id.native_assets_ad_image);
        adChoiceIcon = (ImageView) containerView.findViewById(R.id.native_assets_ad_choices_icon);
        rating = (RatingBar) containerView.findViewById(R.id.native_assets_ad_star_rating);
        return containerView;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final NativeAssetsConfig.Builder builder = new NativeAssetsConfig.Builder()
                .prefetchAdChoiceIcon(true)
                .prefetchIcon(true)
                .prefetchImage(true);

        final String adUnitId = new AdUnitIdStorage(getContext(), AdType.NATIVE).getSelectedAdUnitID();

        nativeAssetsAd = NativeAssetsAdPool.load(getContext(), adUnitId, builder, this);
    }

    @Override
    public void onAdLoaded(@NonNull final NativeAssetsAd nativeAssetsAd, @NonNull final NativeAssets nativeAssets) {
        final List<View> clickableViews = new ArrayList<>();
        if (title != null) {
            title.setText(nativeAssets.getTitle());
            clickableViews.add(title);
        }
        if (body != null) {
            body.setText(nativeAssets.getText());
        }
        if (icon != null) {
            renderImageView(icon, nativeAssets.getIcon());
            clickableViews.add(icon);
        }
        if (image != null) {
            renderImageView(image, nativeAssets.getImage());
            clickableViews.add(image);
        }
        if (cta != null) {
            cta.setText(nativeAssets.getCallToAction());
            clickableViews.add(cta);
        }
        final AdChoice adChoice = nativeAssets.getAdChoice();
        if (adChoice != null) {
            if (adChoiceIcon != null) {
                adChoiceIcon.setImageDrawable(adChoice.getIcon().getDrawable());
                nativeAssetsAd.registerAdChoiceViewForClick(adChoiceIcon);
            }
            if (adChoiceText != null) {
                adChoiceText.setText(adChoice.getIconCaption());
                nativeAssetsAd.registerAdChoiceViewForClick(adChoiceText);
            }
        }
        if (rating != null) {
            renderRatingBarView(rating, nativeAssets.getRating());
        }
        nativeAssetsAd.registerViewsForClick(clickableViews);
        if (adContainer != null) {
            adContainer.setVisibility(View.VISIBLE);
            nativeAssetsAd.registerViewForImpression(adContainer);
        }
        MessageUtils.showAdLoaded(getContext());
    }

    @Override
    public void onAdFailed(@NonNull final NativeAssetsAd nativeAssetsAd, @NonNull final ResponseStatus responseStatus) {
        MessageUtils.showAdFailed(getContext(), responseStatus);
    }

    @Override
    public void onAdOpened(@NonNull final NativeAssetsAd nativeAssetsAd) {
        MessageUtils.showAdOpened(getContext());
    }

    @Override
    public void onAdClicked(@NonNull final NativeAssetsAd nativeAssetsAd) {
        MessageUtils.showAdClicked(getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (nativeAssetsAd != null) {
            nativeAssetsAd.destroy();
        }
    }
}
