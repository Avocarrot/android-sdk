[中文](localization/zh/README.md) - [Português](localization/pt/README.md)

# Avocarrot SDK Integration

Boost your app's revenue streams and save time: sign up for an account at [Avocarrot.com](https://www.avocarrot.com)

## Contents

* [Avocarrot Support](#avocarrot-support)
* [Supported Ad Networks and Ad Types](#supported-ad-networks-and-ad-types)
* [Requirements and Dependencies](#requirements-and-dependencies)
* [Add the Avocarrot SDK and 3rd-party Networks to your Project](#add-the-avocarrot-sdk-and-3rd-party-networks-to-your-project)
* [Modify your Android Manifest](#modify-your-android-manifest)
* [Banner Initialization](#banner-initialization)
* [Interstitial Initialization and Activity](#interstitial-initialization-and-activity)
* [Video Initialization and Activity](#video-initialization-and-activity)
* [Native Assets](#native-assets)
* [Native and In-Feed, Templates and UI](#native-and-in-feed-templates-and-ui)
* [Ad Events Handling (Callbacks)](#ad-events-handling-callbacks)
* [Activity lifecycle events handling](#activity-lifecycle-events-handling)
* [Ad Networks Setting](#ad-networks-settings)
* [Demo (Sample) App/ Testing](#demo-sample-app-testing)

## Avocarrot Support

Additional documentation for integrating the Avocarrot SDK with your Android app can be found by clicking the links.

- [Avocarrot.com Tutorials](https://app.avocarrot.com/#/docs) - Tutorials and Sign Up to Avocarrot
- [Publisher's Self-Serve UI User Guide](https://app.avocarrot.com/#/docs/getting-started/android) - Publisher's Interface Guide
- [Avocarrot FAQ](https://app.avocarrot.com/#/docs/faq) - Support and FAQ

## Supported Ad Networks and Ad Types ##

Avocarrot supports the following ad networks on the client-side:

To show *standard banner* ads:

| Specification | Network | Version |
|----------|----------|----------|
|`mediation-admob-banner`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.2.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-banner`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-banner`| [Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-inlocomedia-banner`| [InLocoMedia](http://docs.inlocomedia.com)| v3.2.1, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

To show *interstitial* ads:

| Specification | Network | Version |
|----------|----------|----------|
|`mediation-admob-interstitial`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.2.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-interstitial`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-chartboost-interstitial`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v7.0.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-facebook-interstitial`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-nativex-interstitial`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-applovin-interstitial`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-interstitial`| [InLocoMedia](http://docs.inlocomedia.com)| v3.2.1, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

To show *video* ads:

| Specification | Network | Version |
|----------|----------|----------|
|`mediation-unityads-video`|[Unity Ads](https://github.com/Applifier/unity-ads-sdk)|v2.1.0, API 9: Android 2.3 (Gingerbread)|
|`mediation-chartboost-video`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v7.0.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-nativex-video`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-vungle-video`|[Vungle](https://v.vungle.com/sdk)|v4.1.0, API 14: Android 4.0 (Ice Cream Sandwich)|

To show *native* ads:

| Specification | Network | Version |
|----------|----------|----------|
|`mediation-admob-nativead`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.2.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-nativead`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-nativead`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-applovin-nativead`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-nativead`| [InLocoMedia](http://docs.inlocomedia.com)| v3.2.1, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

> We can't guarantee stable functionality of the SDK if you use other versions of these network libraries.

You must set up each 3rd-party network on the Avocarrot website, otherwise they will not be used for showing ads.

## Requirements and Dependencies ##

* Android 4.0 (API Version 14) and up
* support-annotations, v26.0.1
* support-v4, v26.0.1
* **Recommended** Google Play Services 11.2.0

We strongly recommend compiling your app using **Google Play services**, in order to use the `Android Advertising ID`
instead of the`Device ID`, as required by Google. Failing to correctly use the `Android Advertising ID` may result in your submission to the Play Store being rejected.

>NOTE: You must have a different **adUnitId** for every ad space placement in your app. If you use the same ID for multiple placements or the IDs from the testing/demo examples, reporting errors will occur and there will be no payout. Please ask your account manager for further details.

## Add the Avocarrot SDK and 3rd-party Networks to your Project ##
The Avocarrot SDK is available via:

1. jCenter AAR (**Recommended**)
2. Zipped AAR

Add the following rows in your _app_ module `build.gradle` file:

```
repositories {
  maven { url "https://s3.amazonaws.com/avocarrot-android-builds/dist/" }
}

dependencies {
  compile 'com.avocarrot.sdk:mediation-sdk-banner:4.6.0'
  compile 'com.avocarrot.sdk:mediation-sdk-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-sdk-video:4.6.0'
  compile 'com.avocarrot.sdk:mediation-sdk-nativead:4.6.0'
  //3rd party SDKs if you need. Don't need to corresponding mediation-sdk module
  compile 'com.avocarrot.sdk:mediation-admob-banner:4.6.0'
  compile 'com.avocarrot.sdk:mediation-admob-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-admob-nativead:4.6.0'
  compile 'com.avocarrot.sdk:mediation-applovin-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-applovin-nativead:4.6.0'
  compile 'com.avocarrot.sdk:mediation-chartboost-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-facebook-banner:4.6.0'
  compile 'com.avocarrot.sdk:mediation-facebook-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-facebook-nativead:4.6.0'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-banner:4.6.0'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-nativead:4.6.0'
  compile 'com.avocarrot.sdk:mediation-mopub-banner:4.6.0'
  compile 'com.avocarrot.sdk:mediation-mopub-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-mopub-nativead:4.6.0'
  compile 'com.avocarrot.sdk:mediation-nativex-interstitial:4.6.0'
  compile 'com.avocarrot.sdk:mediation-nativex-video:4.6.0'
  compile 'com.avocarrot.sdk:mediation-unityads-video:4.6.0'
  compile 'com.avocarrot.sdk:mediation-vungle-video:4.6.0'

  compile 'com.google.android.gms:play-services-ads:11.2.0'
}
```

### Include the Local .aar Libraries ###

Save the `aar` files under _app_ module's `libs` folder (eg: `<project>/<app>/libs`)

Then add the following rows in your _app_ module `build.gradle` file:

```
repositories {
  flatDir {
    dirs 'libs'
  }
}

dependencies {
  compile(name: 'core', version:'4.6.0', ext: 'aar')
  compile(name: 'insights', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-sdk', version:'4.6.0', ext: 'aar')
  
  //To use Native Assets only 
  compile(name: 'mediation-sdk-native-assets', version:'4.6.0', ext: 'aar')
  
  //To use Banners and Interstitials
  compile(name: 'mediation-sdk-mraid', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-sdk-banner', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-sdk-interstitial', version:'4.6.0', ext: 'aar')
  
  //To use Video and Native Ads
  compile(name: 'mediation-sdk-vast', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-sdk-video', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-sdk-nativead', version:'4.6.0', ext: 'aar')
  
  //3rd party SDKs
  compile(name: 'mediation-admob', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-admob-banner', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-admob-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-admob-nativead', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-applovin', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-applovin-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-applovin-nativead', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-chartboost', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-chartboost-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-facebook', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-facebook-banner', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-facebook-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-facebook-nativead', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-inlocomedia', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-inlocomedia-banner', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-inlocomedia-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-inlocomedia-nativead', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-mopub', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-mopub-banner', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-mopub-interstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-mopub-nativead', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-nativex', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-nativex-inerstitial', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-nativex-video', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-unityads', version:'4.6.0', ext: 'aar')
  compile(name: 'mediation-unityads-video', version:'4.6.0', ext: 'aar'
  compile(name: 'mediation-vungle', version:'4.6.0', ext: 'aar'))
  compile(name: 'mediation-vungle-video', version:'4.6.0', ext: 'aar')

  compile 'com.google.android.gms:play-services-ads:11.2.0'
  compile 'com.facebook.android:audience-network-sdk:4.25.0'
  compile('com.mopub:mopub-sdk-banner:4.15.0@aar') {
    transitive = true
  }
  compile('com.mopub:mopub-sdk-interstitial:4.15.0@aar') {
      transitive = true
  }
  compile('com.mopub:mopub-sdk-native-static:4.15.0@aar') {
        transitive = true
  }
  compile 'com.inlocomedia.android:android-sdk:3.2.1'
}
```

Then add follow rows in your _app_ module `proguard-rules.pro` file:

```
-keep class com.avocarrot.** { *; }
-dontwarn com.avocarrot.**
```

## Modify your Android Manifest ##

Under the main `<manifest>` element, add the following permissions.

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
```
* ACCESS_COARSE_LOCATION (recommended) - Grants the SDK permission to access approximate location based on cell tower.
* ACCESS_FINE_LOCATION (recommended) - Grants the SDK permission to access a more accurate location based on GPS.

Although not technically required, the LOCATION permissions make it possible for the SDK to send location-based data to advertisers. Sending better
location data generally leads to better monetization.

* WRITE_EXTERNAL_STORAGE (optional) - Allows the SDK to cache all ad assets (creatives, custom frames, etc.) in external memory. This can maximize
performance by ensuring immediate delivery of ads and minimize network traffic used by the SDK by keeping cached
ad assets available even after the user closes the app.

* READ_PHONE_STATE (recommended) - Allows the SDK to handle calls interrupting video playback during videos.

> When using SDK as a library project, you shouldn't need to worry about merging AndroidManifest.xml changes or Proguard settings. If you run into problems, make sure `manifestmerger.enabled` is set to `true` in `project.properties`

Please see the Android documentation [here](https://developer.android.com/studio/build/shrink-code.html).

## Banner Initialization ##
Add a banner to layout file, e.g.:
```xml
<FrameLayout
    android:id="@+id/ad_view"
    android:layout_width="320dp"
    android:layout_height="50dp"
    android:background="@android:color/white"/>
```

It is advisable to make the banner size in the layout the same as teh required one (see below). Otherwise, the banner might be displayed incorrectly.

Add the following code to your activity:
```java
FrameLayout adView = (FrameLayout) findViewById(R.id.ad_view);
BannerAd bannerAd = BannerAdPool.load(this, "YOUR_BANNER_AD_UNIT_ID", adView, BannerSize.BANNER_SIZE_320x50, bannerAdListener);
```

Available sizes:

* BannerSize.BANNER_SIZE_320x50 for 320x50 size
* BannerSize.BANNER_SIZE_300x250 for 300x250 size (MREC)
* BannerSize.BANNER_SIZE_728x90 for 728x90 size

### Banner Auto-update

You can switch the banner auto-update function on or off; to do this, call `setAutorefreshEnabled()` method, e.g.:
```java
bannerAd.setAutorefreshEnabled(false);
```

By default, auto-update is switched on. The auto-update period is set up via the admin panel.

If you need to reload Banner manually, call
```java
bannerAd.reloadAd();
```

## Interstitial Initialization and Activity ##

> Note: All SDK method calls should be done from the main thread (Main thread, UI thread).

### Interstitial Ad Initialization

Add the following code to your activity:
```java
InterstitialAd interstitialAd = InterstitialAdPool.load(this, "YOUR_INTERSTITIAL_AD_UNIT_ID", interstitialAdListener);
```
After calling the `loadAd()` method, the interstitial download starts. If you call `loadAd()` again before the banner is fully served, the previous request processing is cancelled. In this case, only the last request will be processed.

When the banner download is completed, you can display the banner by calling `showAd()` method.
```java
interstitialAd.showAd();
```

To learn about download completion, subscribe to banner events (see [Ad Events Handling](#ad-events-handling-callbacks)) or call method `isReady()`.
```java
interstitialAd.isReady();
```

If your application workflow allows showing full screen banners at any time and in any place, there are 2 additional ways to show it right after the loading has finished or with a custom delay after method invocation.

To load and show full screen banner right after it was loaded use:
```java
InterstitialAdPool.loadAndShow(this, "YOUR_INTERSTITIAL_AD_UNIT_ID", interstitialAdListener);
```

To load and show full screen banner with a custom delay after method invocation use:
```java
InterstitialAdPool.loadAndShowWithDelay(this, "YOUR_INTERSTITIAL_AD_UNIT_ID", interstitialAdListener);
```
The delay interval is specified via Admin UI interface.

If you need to reload Interstitial manually, call
```java
interstitialAd.reloadAd();
```
or
```java
interstitialAd.reloadAndShowAd();
```
or
```java
interstitialAd.reloadAndShowAdWithDelay();
```

If you want full control over when and where to show full screen banners, use the following steps:

1. Set `InterstitialAdCallback` to handle interstitial events
2. Call `InterstitialAdPool.loadAd()` in advance
3. When you want to show the interstitial, check that it is ready and show: `if (interstitialAd.isReady()) interstitialAd.showAd()`
4. Start loading next interstitial in `onAdClosed()` event handler of `InterstitialAdCallback`

## Video Initialization and Activity ##

> Note: All SDK method calls should be done from the main thread (Main thread, UI thread).

### Video Ad Initialization

Add the following code to your activity:
```java
VideoAd videoAd = VideoAdPool.load(this, "YOUR_VIDEO_AD_UNIT_ID", closeButtonEnabled, videoAdListener);
```

The *Close* button for video ads is supported for some networks. You can enable or disable it by changing `closeButtonEnabled` parameter.

If you call `reloadAd()` before the video has started to show, new request processing is cancelled. Only one request will be processed.

When the video download is completed, you can display it by calling the `showAd()` method.
```java
videoAd.showAd();
```

To learn about download completion, subscribe to video banner events (see [Ad Events Handling](#ad-events-handling-callbacks) section) or call method `isReady()`.
```java
videoAd.isReady();
```

## Native Assets ##

Our native assets ad is a raw ad data without any pre-defined wrapping UI. The layout for the native assets ad is configured and rendered by developers.

> Note: Use Native type in Avocarrot UI to configure Native Assets Ad networks. Currently the Native Assets do not supports client mediation networks such as AdMob, Facebook, MoPub, etc.

Add the following code to your activity:
```java
NativeAssetsAd nativeAssetsAd = NativeAssetsAdPool.load(context, "YOUR_NATIVE_AD_UNIT_ID", nativeAssetsAdListener);
```

You can configure `Builder` for `NativeAssetsAd` to load image resources by adding this lines to it:
```java
final NativeAssetsConfig.Builder config = new NativeAssetsConfig.Builder()
       .prefetchIcon(true)
       .prefetchImage(true)
       .prefetchAdChoiceIcon(true);

nativeAssetsAd = NativeAssetsAdPool.load(this, getAdUnitId(), config, this);
```

Or you can manage resources downloading by yourself, when you will receive a `NativeAssets` object in `onAdLoaded` callback:
```java
    public void onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets) {
        Image icon = nativeAssets.getIcon();
        if (icon != null) {
            String iconUrl = icon.getUrl();
            /* your image downloading code here */
        }
    }
```

There is a common algorithm to use when implementing a Native Assets Ad:
1. Create your own subclass of `View`  which will be used as ad view container.
3. Initialize `NativeAssetsAd` by `NativeAssetsAdPool.load(context, "YOUR_NATIVE_AD_UNIT_ID", nativeAssetsAdListener);` call to start loading of assets
4. Get `NativeAssets` in `onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets)` callback of `nativeAssetsAdListener`
5. Render the Ad view container
6. Register the Ad views for impressions and clicks: 
    - call `nativeAssetsAd.registerViewForImpression(adContainer)` to register your Ad container view for impression;
    - to register ad views for click events call `.registerViewsForClick(clickableViewList)`;
    - call `.registerAdChoiceViewForClick(adChoiceView)` to register AdChoice view for clicks.
7. Unregister the Ad views by calling `.unregisterViews()` when you are no longer displaying them.
8. Destroy the `NativeAssetsAd` by calling `.destroy()` when you're not going to use it anymore.

For example:

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        adContainer = (LinearLayout) findViewById(R.id.native_assets_ad_container);
        title = (TextView) findViewById(R.id.native_assets_ad_title);
        body = (TextView) findViewById(R.id.native_assets_ad_body);
        adChoiceText = (TextView) findViewById(R.id.native_assets_ad_choices_caption);
        cta = (TextView) findViewById(R.id.native_assets_ad_call_to_action);
        icon = (ImageView) findViewById(R.id.native_assets_ad_icon);
        image = (ImageView) findViewById(R.id.native_assets_ad_image);
        adChoiceIcon = (ImageView) findViewById(R.id.native_assets_ad_choices_icon);
        rating = (RatingBar) findViewById(R.id.native_assets_ad_star_rating);
        final NativeAssetsConfig.Builder config = new NativeAssetsConfig.Builder()
                        .prefetchIcon(true)
                        .prefetchImage(true)
                        .prefetchAdChoiceIcon(true);
        NativeAssetsAd nativeAssetsAd = NativeAssetsAdPool.load(context, "YOUR_NATIVE_AD_UNIT_ID", config, nativeAssetsAdListener);
        ...
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (nativeAssetsAd != null) {
            nativeAssetsAd.destroy();
        }
    }
    
    @Override
    public void onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets) {            
        title.setText(nativeAssets.getTitle());
        body.setText(nativeAssets.getText());
        renderImageView(icon, nativeAssets.getIcon());
        renderImageView(image, nativeAssets.getImage());
        cta.setText(nativeAssets.getCallToAction());
        AdChoice adChoice = nativeAssets.getAdChoice();
        if (adChoice != null) {                       
            adChoiceIcon.setImageDrawable(adChoice.getIcon().getDrawable());
            nativeAssetsAd.registerAdChoiceViewForClick(adChoiceIcon);
        }
        renderRatingBarView(rating, nativeAssets.getRating());
        nativeAssetsAd.registerViewsForClick(Arrays.asList(title, icon, image, cta));
        nativeAssetsAd.registerViewForImpression(adContainer);
    }
    
    private static void renderImageView(@NonNull ImageView view, Image image) {
        if (image != null) {
            view.setVisibility(View.VISIBLE);
            view.setAdjustViewBounds(true);
            int width = image.getWidth();
            int height = image.getHeight();
            if (width > 0 && height > 0) {
            view.setMaxWidth(width);
                view.setMaxHeight(height);
            }
            view.setImageDrawable(image.getDrawable());
        } else {
            view.setImageDrawable(null);
            view.setVisibility(GONE);
        }
    }
    
    private static void renderRatingBarView(@NonNull RatingBar view, @Nullable Rating starRating) {
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
    
```


## Native and In-Feed, Templates and UI ##

>Note: All SDK method calls should be done from the main thread (Main thread, UI thread).

Native ads are loaded via the `NativeAd` class. `NativeAdView` is a `ViewGroup` that provides representation of `NativeAd`. To configure `NativeAdView` you can set `NativeAdView.Builder` and `NativeAdView.Attributes` to customize it during creation:

```java
NativeAd nativeAd = NativeAdPool.load(context, YOUR_NATIVE_AD_UNIT_ID, ListNativeAdView.BUILDER, nativeAdListener);
```

To show native ads you can use two methods:

* Create an ad view programmatically from template and add it to the screen.
* Add `NativeAdView` view in the layout and bind loaded data to this view.

### Templates

Avocarrot SDK provides 5 types of templates for native ads

* FeedNativeAdView - Icon, title, description, star rating, and CTA button
* ListNativeAdView - Icon, image/video/carousel, title, description, star rating, and CTA button
* GridNativeAdView - Special template for using in StreamAdRecyclerAdapter with GridLayoutManager. Currently available for RecyclerView with two columns only.
* DynamicNativeAdView - Special template for using with Template Service in Avocarrot Dashboard.
* FullscreenNativeAdView - Fullscreen template to make your Native Ad looks like Interstitial Ad. Available only to use with single NativeAd only.

> Every template has a label that clearly indicates that it is an ad. For example "Ad" or "Sponsored".

If you want to use one of these templates, you can add the selected template in the creation of the `NativeAd`:

```java
.setAdViewBuilder(ListNativeAdView.BUILDER);
```


Add a banner place to layout, e.g.:
``` xml
  <FrameLayout
    android:id="@+id/ad_container"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:visibility="gone"/>
```

When the NativeAd downloading is completed, you can display the banner by calling `renderAdView()` method.

```java
adContainerView = (FrameLayout) view.findViewById(R.id.ad_container);

@Override
public void onAdLoaded() {
  adContainerView.setVisibility(View.VISIBLE);
  adContainerView.removeAllViews();
  adContainerView.addView(nativeAd.renderAdView());
}
```

### Create Native UI

In order to create custom native ads ui, you will need to go through following steps:

* Create all needed views (icon view, main image view, text views, rating bar etc...)
* Pass the views to our SDK

You can either create your custom views in a layout `.xml`, or you can add elements in the code.

> All views should be placed in one child; this child itself should be placed in `NativeAdView`.

Custom layout `.xml`. For example:

``` xml
<com.avocarrot.sdk.nativead.NativeAdView android:id="@+id/native_ad"
 ...>
    <RelativeLayout ...>
        <ImageView android:id="@+id/native_ad_icon"
          ... />
        <ImageView android:id="@+id/native_ad_cover_image"
          ... />
        <FrameLayout android:id="@+id/native_ad_media_container"
          ... />
        <TextView android:id="@+id/native_ad_title"
          ... />
        <TextView android:id="@+id/native_ad_text"
          ... />
        <RatingBar android:id="@+id/native_ad_star_rating"
          ... />
        <Button android:id="@+id/native_ad_call_to_action"
          ... />
        <TextView android:id="@+id/native_ad_attribution"
          ... />
        <ImageView android:id="@+id/native_ad_choices_icon"
          android:layout_width="40dp"
          android:layout_height="40dp"
          android:padding="10dp"
          ... />
        <FrameLayout
          android:id="@+id/native_ad_choices_container"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:minHeight="20dp"
          android:minWidth="20dp"
          ... />
    </RelativeLayout>
</com.avocarrot.sdk.nativead.NativeAdView>
```

After you created all the views, please proceed by passing the views to our SDK. For example:

```java
  adView = (NativeAdView) view.findViewById(R.id.native_ad);

  adView.setIconView(R.id.native_ad_icon);
  adView.setCoverImageView(R.id.native_ad_cover_image);
  adView.setMediaContainerView(R.id.native_ad_media_container);
  adView.setTextView(R.id.native_ad_text);
  adView.setTitleView(R.id.native_ad_title);
  adView.setCallToActionView(R.id.native_ad_call_to_action);
  adView.setStarRatingView(R.id.native_ad_star_rating);
  adView.setAdAttributionView(R.id.native_ad_attribution);
  adView.setAdChoiceIconView(R.id.native_ad_choices_icon);
  adView.setAdChoiceContainerView(R.id.native_ad_choices_container);
```

After calling the `reloadAd()` method, the ad download starts. If you call `reloadAd()` again before the NativeAd is fully served, new request processing is
ignored. In this case, only the last request will be processed.

To learn about download completion, subscribe to ad events (see [Ad Events Handling](#ad-events-handling-callbacks) section) or call method `isReady()`.
```java
nativeAd.isReady();
```

### Customize Native UI

With a native template, you can customize the following elements:

* Title
    * Text font (DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF)
    * Text size
    * Text color
    * Max Ems (25 by default)
* Icon
    * Dimensions(width, height)
    * Margins (left, right)
* Star rating
    * Star size (SMALL, MEDIUM, LARGE)
* Attribution label
    * Default text
    * Text font (DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF)
    * Text size
    * Text color
* Cover image
    * Background color
    * Background resource
    * Margins (left, right, bottom, top)
    * Alignment (undefine, top, bottom, left, right, center, center_vertical, center_horizontal)
* Description
    * Text font (DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF)
    * Text size
    * Text color
    * Margins (left, right)
    * Max Ems (100 by default)
* Call To Action button
    * Default text
    * Text font (DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF)
    * Text size
    * Text color
    * Max Ems (25 by default)
    * Background color
    * Background resource
    * Margins (left, right)

In order to customize these elements, you will need to build an attributes object and provide the following in the creation of the `NativeAd`:
```java
NativeAdView.Attributes adViewAttributes = new NativeAdView.Attributes(this)
    .setTitle(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.Title>() {
        @Override
            public NativeAdView.Attributes.Title set(@NonNull NativeAdView.Attributes.Title builder) {
                return builder
                        .setTypeface(Typeface.MONOSPACE)
                        .setTextColor(Color.RED)
                        .setMaxLengthEms(20);
            }
    })
    .setStarRating(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.StarRating>() {
        @Override
        public NativeAdView.Attributes.StarRating set(@NonNull NativeAdView.Attributes.StarRating builder) {
            return builder.setStarRatingStyle(NativeAdView.Attributes.StarRating.Style.MEDIUM);
        }
    })
    .setAdAttribution(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.AdAttribution>() {
        @Override
        public NativeAdView.Attributes.AdAttribution set(@NonNull final NativeAdView.Attributes.AdAttribution adAttribution) {
            return adAttribution.setDefaultText(R.string.sponsored);
        }
    })
NativeAd nativeAd = NativeAdPool.load(context, YOUR_NATIVE_AD_UNIT_ID, ListNativeAdView.BUILDER, adViewAttributes, nativeAdListener);
```

Also, you can set the style of your `NativeAdView` layout by using following attributes:

|Attribute Name | Format | Description |
|---|---|---|
| `Title` |
| avoTitleTypeface | DEFAULT, DEFAULT_BOLD, DEFAULT_ITALIC, DEFAULT_BOLD_ITALIC, MONOSPACE, SERIF, SANS_SERIF | Font of the Title text |
| avoTitleTextSize | reference,dimension | Size of the Title text|
| avoTitleTextColor | reference,color | Color of the Title text|
| avoTitleTextMaxLengthEms | integer | Maximum Ems of the Title text|
| `Icon` |
| avoIconWidth | reference,dimension | Icon view width |
| avoIconHeight | reference,dimension |Icon view height|
| avoIconMarginLeft | reference,dimension | Icon view left margin|
| avoIconMarginRight | reference,dimension | Icon view right margin|
| `Star Rating` |
| avoStarRatingSize | SMALL, MEDIUM, LARGE | Size of the rating bar stars. SMALL - 10dp for height and width, MEDIUM - 16dp, LARGE - 22dp|
| `Ad Attribution` |
| avoAdAttributionTypeface | DEFAULT, DEFAULT_BOLD, DEFAULT_ITALIC, DEFAULT_BOLD_ITALIC, MONOSPACE, SERIF, SANS_SERIF | Font of the Attribution label text |
| avoAdAttributionTextSize | reference,dimension | Size of the Ad Attribution text|
| avoAdAttributionTextColor | reference,color | Color of the Ad Attribution text|
| avoAdAttributionDefaultText | reference,string | Default Ad Attribution text|
| `Cover Image` |
| avoCoverImageBackgroundColor | reference,color | Cover Image background color|
| avoCoverImageBackgroundResource | reference | Cover Image background resource|
| avoCoverImageMarginLeft | reference,dimension | Cover Image left margin|
| avoCoverImageMarginRight | reference,dimension | Cover Image right margin|
| avoCoverImageMarginTop | reference,dimension | Cover Image top margin|
| avoCoverImageMarginBottom | reference,dimension | Cover Image bottom margin|
| avoCoverImageAlignment | undefine, top, bottom, left, right, center, center_vertical, center_horizontal | Cover Image alignment within the NativeAd view|
| `Description` |
| avoDescriptionTypeface |  DEFAULT, DEFAULT_BOLD, DEFAULT_ITALIC, DEFAULT_BOLD_ITALIC, MONOSPACE, SERIF, SANS_SERIF | Font of the Description text |
| avoDescriptionTextSize | reference,dimension | Size of the Description text|
| avoDescriptionTextColor | reference,color | Color of the Description text|
| avoTitleTextMaxLengthEms | integer | Maximum Ems of the Description text|
| avoDescriptionMarginLeft | reference,dimension | Description view left margin|
| avoDescriptionMarginRight | reference,dimension | Description view right margin|
| `Call To Action` |
| avoCallToActionBackgroundColor |  reference,color | Color of the Call To Action button |
| avoCallToActionTypeface | DEFAULT, DEFAULT_BOLD, DEFAULT_ITALIC, DEFAULT_BOLD_ITALIC, MONOSPACE, SERIF, SANS_SERIF | Font of the Description text |
| avoCallToActionTextSize | reference,dimension | Size of the Call To Action button text|
| avoCallToActionTextColor | reference,color | Color of the Call To Action button text|
| avoCallToActionMarginLeft | reference,dimension | Call To Action button view left margin|
| avoCallToActionMarginRight | reference,dimension | Call To Action button view right margin|
| avoCallToActionMarginTop | reference,dimension | Call To Action button view top margin|
| avoCallToActionMarginBottom | reference,dimension | Call To Action button view bottom margin|
| avoCallToActionDefaultText | reference,string | Default Call To Action text|

You can set this attributes in your custom `NativeAdView` layout
``` xml
<com.avocarrot.sdk.nativead.NativeAdView android:id="@+id/native_ad"
    app:avoTitleTypeface="MONOSPACE"
    app:avoIconWidth="42dp"
    app:avoIconHeight="42dp"
    app:avoCallToActionTextColor="@android:color/lighter_gray"
 ...>
```

### In-Feed Viewer ###

> Note: All SDK method calls should be done from the main thread (Main thread, UI thread).

Add the following code to your activity:

#### ListView ####

```java
StreamAdBaseAdapter adAdapter = new StreamAdBaseAdapter.Builder()
  .setAdapter(new MainAdapter(this))
  .setAdUnitId("YOUR_NATIVE_AD_UNIT_ID")
  .setViewBuilder(ListNativeAdView.BUILDER)
  .setStreamNativeAdCallback(streamNativeAdListener)
  .build(this);
listView.setAdapter(adAdapter);
adAdapter.loadAd();
```

#### RecyclerView ####

```java
StreamAdRecyclerAdapter adAdapter = new StreamAdRecyclerAdapter.Builder()
  .setAdapter(new MainAdapter(this))
  .setAdUnitId("YOUR_NATIVE_AD_UNIT_ID")
  .setViewBuilder(FeedNativeAdView.BUILDER)
  .setStreamNativeAdCallback(streamNativeAdListener)
  .build(this);
recyclerView.setLayoutManager(layoutManager);
recyclerView.setAdapter(adAdapter);
adAdapter.loadAd();
```

After calling the `loadAd()` method, the in-feed ad download starts. If you call `loadAd()` again before the native ad is fully served, new request processing is cancelled. Only one request will be processed.

When in-feed ad download is completed, it will show automatically.

To learn about download completion, subscribe to ad events (see [Ad Events Handling](#ad-events-handling-callbacks) section).


## Ad Events Handling (Callbacks)

To receive events from ad, you should implement one of an event listener interfaces:

for `BannerAd`: 
```java
BannerAdCallback bannerdAdListener = new BannerAdCallback() {
    @Override
    public void onAdLoaded(@NonNull BannerAd ad) {
    }

    @Override
    public void onAdFailed(@NonNull BannerAd ad, @NonNull ResponseStatus responseStatus) {
    }

    @Override
    public void onAdOpened(@NonNull BannerAd ad) {
    }

    @Override
    public void onAdClicked(@NonNull BannerAd ad) {
    }

    @Override
    public void onAdClosed(@NonNull BannerAd ad) {
    }
};
```

and similar `InterstitialAdCallback` for `InterstitialAd`.

For `VideoAd` and `NativeAd` callback interfaces are also similar, but have additional call on video playback completion:    
```java
NativeAdCallback nativeAdListener = new NativeAdCallback() {
    
    ...
    
    @Override
    public void onAdCompleted(@NonNull NativeAd ad) {
    }
};
```

for the `NativeAssetsAd` you will receive a `NativeAssets` object with a raw native ad data provided:
```java
NativeAssetsAdCallback nativeAssetsAdListener = new InterstitialAdCallback() {
    @Override
    public void onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets) {
    }
    
    @Override
    public void onAdFailed(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull ResponseStatus responseStatus) {
    }
    
    @Override
    public void onAdOpened(@NonNull NativeAssetsAd nativeAssetsAd) {
    }
    
    @Override
    public void onAdClicked(@NonNull NativeAssetsAd nativeAssetsAd) {    
    }
};
```

## Activity lifecycle events handling

`onActivityResumed()`, `onActivityPaused()` and `onActivityDestroyed()` methods should be called depending on the activity lifecycle events.

Example:
```java
@Override
protected void onResume() {
    super.onResume();
    interstitialAd.onActivityResumed();
    bannerAd.onActivityResumed();
    videoAd.onActivityResumed();
    nativeAd.onActivityResumed();
}

@Override
protected void onPause() {
    super.onPause();
    interstitialAd.onActivityPaused();
    bannerAd.onActivityPaused();
    videoAd.onActivityPaused();
    nativeAd.onActivityPaused();
}

@Override
protected void onDestroy() {
    super.onDestroy();
    interstitialAd.onActivityDestroyed();
    bannerAd.onActivityDestroyed();
    videoAd.onActivityDestroyed();
    nativeAd.destroy();
}
```
Note: It's not strictly necessary to call `onActivityPaused()` and `onActivityResumed()` methods to use NativeAd, but we strongly recommend to call them if you are using NativeAds with video content
## Ad Networks Settings

If you set TEST MODE with `Avocarrot.setTestMode(true)` all "HASHED_ID" will be set automatically.

### AdMob

```java
Avocarrot.addMediationAdapter(new AdMobMediation.Builder()
    .addTestDevice("HASHED_ID")
    .build());
```

### Facebook

```java
Avocarrot.addMediationAdapter(new FacebookMediation.Builder()
    .addTestDevice("HASHED_ID")
    .build());
```

### InLocoMedia

```java
Avocarrot.addMediationAdapter(new InLocoMediaMediation.Builder()
    .addTestDevice("HASHED_ID")
    .build());
```
## Demo (Sample) App/ Testing

### Steps

1. Download the Avocarrot Demo (Sample) from GitHub.
2. Import the Avocarrot Demo (Sample App) into Android Studio under *File > New > Import Project*.
3. In the Avocarrot UI, set the status of **the Ad Unit you want to use** to *Test*.
4. In the Avocarrot UI, click the "Click to Copy Ad Unit ID" button to copy the placement ID to the clipboard.
5. In Android Studio, in the Java activity of the Ad Type of **the Ad Unit you want to use**, paste the Ad Unit ID from initialisation step.
6. In the Android Studio main menu, select **Run** and click *Run* to compile and run the App.
7. In the Android emulator (or your device) where the app is running with Avocarrot, select the Ad Type from initialisation  and you will see the event register in the Avocarrot Publishers's Self Serve UI under *Reporting*.

[For advanced SDK topics, click here.](CONFIGURATIONS.md)
