[Português](localization/pt/README.md)

# Avocarrot SDK 集成 

提升收入和节省时间：请在[Avocarrot.com](https://avocarrot.com)注册帐户

## Contents

* [Avocarrot支持](#avocarrot支持)
* [平台和广告类支持](#平台和广告类支持)
* [需求和依赖](#需求和依赖)
* [添加AvocarrotSDK和第三方平台到项目](#添加avocarrotsdk和第三方平台到项目)
* [更新Android Manifest](#更新android-manifest)
* [标准横幅广告初始化和活动](#标准横幅广告初始化)
* [插屏广告初始化和活动](#插屏广告初始化和活动)
* [视频广告初始化和活动](#视频广告初始化和活动)
* [原生和Feed广告，模版和UI](#原生和feed广告模版和ui)
* [广告回调](#广告回调)
* [活动生命周期](#活动生命周期)
* [广告平台测试设置](#广告平台测试设置)
* [Demo（示例）应用/测试](#demo示例应用测试)

## Avocarrot支持
通过单击链接可以找到有关将Avocarrot SDK与Android应用集成的其他文档。

- [Avocarrot.com Tutorials](https://app.avocarrot.com/#/docs) - 视频教程整合加注册
- [Publisher's Self-Serve UI User Guide](https://app.avocarrot.com/#/docs/getting-started/android) - 出版商界面
- [Zendesk Support](https://app.avocarrot.com/#/docs/faq) - 支持和常见问题

## 平台和广告类支持 ##

Avocarrot 在客户端一侧支持以下广告平台：

为了显示标准横幅广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-banner`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.0.4, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-banner`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-banner`| [Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-inlocomedia-banner`| [InLocoMedia](http://docs.inlocomedia.com)| v3.0.7, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

为了显示插屏广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-interstitial`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.0.4, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-interstitial`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-chartboost-interstitial`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v6.6.3, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-facebook-interstitial`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-nativex-interstitial`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-applovin-interstitial`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-interstitial`| [InLocoMedia](http://docs.inlocomedia.com)| v3.0.7, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

为了显示视频广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-unityads-video`|[Unity Ads](https://github.com/Applifier/unity-ads-sdk)|v2.1.0, API 9: Android 2.3 (Gingerbread)|
|`mediation-chartboost-video`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v6.6.3, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-nativex-video`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-vungle-video`|[Vungle](https://v.vungle.com/sdk)|v4.1.0, API 14: Android 4.0 (Ice Cream Sandwich)|

为了显示原生广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-nativead`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.0.4, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-nativead`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.15.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-nativead`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.25.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-applovin-nativead`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-nativead`| [InLocoMedia](http://docs.inlocomedia.com)| v3.0.7, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

> 如果您使用其他版本的网络库，我们不能保证SDK的稳定功能。

您必须在Avocarrot网站上设置每个第三方平台，否则它们不会用于展示广告。

## 需求和依赖 ##

* Android 2.3 (API Version 9) and up
* support-annotations, v25.4.0
* support-v4, v25.4.0
* **推荐** Google Play Services 11.0.4

我们强烈建议使用Google Play services编译你的app，从而按照Google的要求使用Android Advertising ID代替Device ID。没有正确使用Android Advertising ID可能导致你向Play Store的提交被拒绝。

确保你已经获得了Avocarrot提供的所有重要数据：

adUnitId - 用于app中每一种不同的广告空间布置

请向你的帐户管理员了解进一步细节。如果发行商使用来自示例的ID，则不会付费。

## 添加AvocarrotSDK和第三方平台到项目 ##
可通过以下方式获取Avocarrot SDK ：

1. jCenter AAR (**Recommended**)
2. Zipped AAR

在your app module build.gradle 文件中增加以下行：

```
repositories {
  maven { url "https://s3.amazonaws.com/avocarrot-android-builds/dist/" }
}

dependencies {
  compile 'com.avocarrot.sdk:mediation-sdk-banner:4.5.1'
  compile 'com.avocarrot.sdk:mediation-sdk-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-sdk-video:4.5.1'
  compile 'com.avocarrot.sdk:mediation-sdk-nativead:4.5.1'
  //3rd party SDKs if you need. Don't need to corresponding mediation-sdk module
  compile 'com.avocarrot.sdk:mediation-admob-banner:4.5.1'
  compile 'com.avocarrot.sdk:mediation-admob-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-admob-nativead:4.5.1'
  compile 'com.avocarrot.sdk:mediation-applovin-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-applovin-nativead:4.5.1'
  compile 'com.avocarrot.sdk:mediation-chartboost-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-facebook-banner:4.5.1'
  compile 'com.avocarrot.sdk:mediation-facebook-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-facebook-nativead:4.5.1'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-banner:4.5.1'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-nativead:4.5.1'
  compile 'com.avocarrot.sdk:mediation-mopub-banner:4.5.1'
  compile 'com.avocarrot.sdk:mediation-mopub-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-mopub-nativead:4.5.1'
  compile 'com.avocarrot.sdk:mediation-nativex-interstitial:4.5.1'
  compile 'com.avocarrot.sdk:mediation-nativex-video:4.5.1'
  compile 'com.avocarrot.sdk:mediation-unityads-video:4.5.1'
  compile 'com.avocarrot.sdk:mediation-vungle-video:4.5.1'

  compile 'com.google.android.gms:play-services-ads:11.0.4'
}
```

### 添加本地 .aar libraries ###

将 aar 文件保存在 app module's libs 文件夹下 (例如： <project>/<app>/libs)

然后在your app module build.gradle 文件中增加以下行：

```
repositories {
  flatDir {
    dirs 'libs'
  }
}

dependencies {
  compile(name: 'mediation-sdk-banner', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-sdk-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-sdk-video', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-sdk-nativead', version:'4.5.1', ext: 'aar')
  //3rd party SDKs if you need. Don't need to corresponding mediation-sdk module
  compile(name: 'mediation-adcolony-video', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-admob-banner', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-admob-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-admob-nativead', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-applovin-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-applovin-nativead', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-chartboost-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-facebook-banner', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-facebook-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-facebook-nativead', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-inlocomedia-banner', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-inlocomedia-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-inlocomedia-nativead', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-mopub-banner', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-mopub-interstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-mopub-nativead', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-nativex-inerstitial', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-nativex-video', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-unityads-video', version:'4.5.1', ext: 'aar')
  compile(name: 'mediation-vungle-video', version:'4.5.1', ext: 'aar')

  compile 'com.google.android.gms:play-services-ads:11.0.4'
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
  compile 'com.inlocomedia.android:android-sdk:3.0.7'
  compile 'com.google.code.gson:gson:2.8.1'
}
```

然后在您的app module proguard-rules.pro 文件中添加以下的下行：

```
-keep class com.avocarrot.** { *; }
-dontwarn com.avocarrot.**
```

## 更新Android Manifest ##

在主 <manifest> 元素下，增加以下许可。

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
```
* ACCESS_COARSE_LOCATION (recommended) - Grants the SDK permission to access approximate location based on cell tower.
* ACCESS_FINE_LOCATION (recommended) - Grants the SDK permission to access a more accurate location based on GPS.

尽管技术上没有要求，LOCATION许可使SDK能够向广告商发送基于位置的数据。发送更好的位置数据通常会带来更好的经济效益。

* WRITE_EXTERNAL_STORAGE (optional) - 允许SDK将所有的有用广告数据（创新、用户框架、等等）缓存在外部存储器。这就能通过确保立即投放广告使效果最大化，并通过使缓存的广告数据可用（即使在用户关闭app之后），尽量减少SDK使用的网络流量。

* READ_PHONE_STATE（推荐） - 允许SDK处理视频期间的电话中断视频回放。

当将SDK作为库工程使用时，你无需担心合并AndroidManifest.xml变动或Proguard设置。如果你遇到问题，确保在project.properties中将manifestmerger.enabled设置为true。

请看Android[文档](https://developer.android.com/studio/build/shrink-code.html).

## 标准横幅广告初始化和活动 ##
> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

对布局文件增加一个横幅广告，例如：
```xml
<FrameLayout
    android:id="@+id/ad_view"
    android:layout_width="320dp"
    android:layout_height="50dp"
    android:background="@android:color/white"/>
```
我们建议在布局中使横幅广告的尺寸与要求的相同（见下文）。否则横幅广告可能会不正确显示。

请在您的Activity里添加以下代码：
```java
FrameLayout adView = (FrameLayout) findViewById(R.id.ad_view);
StandardAd standardAd = new StandardAd(this, adView, "YOUR_STANDARD_AD_UNIT_ID", BannerSize.BANNER_SIZE_320x50, adListener);
standardAd.loadAd();
```

默认情况下，投放横幅“320 * 50”。可用尺寸：

* 320*50
* 728*90

### 标准横幅自动更新

您可以打开或关闭横幅广告的自动更新功能；为此，调用setAutorefreshEnabled()方法，例如
```java
standardAd.setAutorefreshEnabled(false);
```
在默认情况下，自动更新打开。通过管理员面板设置自动更新时段。

从3.4版本开始，SDK的接口包括`showAd`方法。我们强烈建议在标准横幅广告视图显示后调用此方法，因为这样会触发展示事件。

## 插屏广告初始化和活动 ##

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

### 插屏广告初始化

请在您的Activity里添加以下代码：
```java
InterstitialAd interstitialAd = new InterstitialAd(this, "YOUR_INTERSTITIAL_AD_UNIT_ID", adListener);
interstitialAd.loadAd();
```
在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求才会生效。

当插屏广告下载完成后，你可以通过调用`showAd()`方法显示插屏广告。
```java
interstitialAd.showAd();
```
为了得知下载是否完成，订阅插屏广告事件（ 请见[AD事件处理](#AD事件处理) ）或调用方法`isReady()`。
```java
interstitialAd.isReady();
```
如果您的申请工作流程允许在任何时间和任何位置显示全屏插屏广告，那么还有两种方法可以在加载完成后或在调用方法设置延迟后正确显示。

如果需要加载全屏插屏广告，并在加载后立即显示，则使用：
```java
interstitialAd.loadAndShow()
```
如果需要加载全屏插屏广告，并在调用方法设定延迟后显示，则使用：
```java
interstitialAd.loadAndShowWithDelay()
```
通过Admin UI接口指定延迟间隔。

如果你想要完全控制全屏插屏广告显示的时间和位置，使用以下步骤：

1. 提前调用 `interstitialAd.loadAd()`
2. 设置 `AdEventCallback` 处理插屏广告事件。
3. 当你希望显示插屏广告时，检查是否准备就绪，并显示：
```
if (interstitialAd.isReady()) 
    interstitialAd.showAd() 
```
4. 在AdEventCallback的事件处理器 onAdClosed()中开始加载下一个插屏广告。

## 视频广告初始化和活动 ##
> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

### 视频广告初始化

请在您的Activity里添加以下代码：
```java
VideoAd videoAd = new VideoAd(this, "YOUR_VIDEO_AD_UNIT_ID", adListener);
videoAd.loadAd();
```
视频广告关闭按钮，支持某些网络。如果要启用这个按钮，你应该在视频广告中添加构造布尔参数:

```java
VideoAd videoAd = new VideoAd(this, "YOUR_VIDEO_AD_UNIT_ID", closeButtonEnabled);
或 
VideoAd videoAd = new VideoAd(this, "YOUR_VIDEO_AD_UNIT_ID", closeButtonEnabled, adListener);
```

在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求才会生效。

当插屏广告下载完成后，你可以通过调用`showAd()`方法显示视频广告
```java
videoAd.showAd();
```
为了得知下载是否完成，订阅视频广告事件（ 请见[AD事件处理](#AD事件处理) ）或调用方法`isReady()`。
```java
videoAd.isReady();
```

## 原生和Feed广告，模版和UI ##

>注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

通过NativeAd类加载原生广告，该类在创建期间具有自己的Builder类进行定制：

```java
NativeAd nativeAd = new NativeAd.Builder()
  .setAdUnitId(YOUR_NATIVE_AD_UNIT_ID)
  .setCallback(adListener)
  .build(this);
```

为了使用原生广告，你可以使用两种方法：

* 通过编程方法从模板创建一个广告视图，并将其加入到屏幕。
* 在布局中增加 NativeAdView 视图，并将加载的数据捆绑到此视图。

### 模板

Avocarrot SDK 对原生广告提供了三类模板

* FeedCardNativeAdView - 图标、标题、说明、星级评定、和CTA按钮
* VideoCardNativeAdView - 图像、图标/视频/ 图片轮播、标题、说明、星级评定、和CTA按钮
* GridNativeAdView - Special template for using in StreamAdRecyclerAdapter with GridLayoutManager. Currently available for RecyclerView with two columns only.

> 每一个模板具有一个标签，清晰的标明了这是一个广告。例如"Ad" 或"Sponsored"。

如果您希望使用模板之一，你可以在NativeAd创建时增加所选的模板： `NativeAd`:

```java
.setAdViewBuilder(FeedCardNativeAdView.BUILDER);
```
对布局增加一个横幅广告位置，例如：
``` xml
  <FrameLayout
    android:id="@+id/ad_container"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:visibility="gone"/>
```

在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求会被处理。

当原生广告下载完成后，你可以通过调用`renderAdView()`方法显示广告。

```java
adContainerView = (FrameLayout) view.findViewById(R.id.ad_container);

@Override
public void onAdLoaded() {
  adContainerView.setVisibility(View.VISIBLE);
  adContainerView.removeAllViews();
  adContainerView.addView(nativeAd.renderAdView());
}
```

### 创建自定义原生广告UI

为了创建自定义的原生广告UI，你需要经过以下步骤：

* 创建所有需要的视图（图标视图、主图像视图、文本视图、评级栏等等……）
* 将视图传给我们的SDK
你既可以在布局.xml中创建你的定制视图，也可以在代码中增加元件。

> 所有视图都应当置于一个子类中；该子类本身应当置于`NativeAdView`中。

定制布局`.xml`。例如：

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

在您创建所有视图之后，请继续将视图发送给我们的SDK。例如：

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

在`NativeAd`的创建中注册原生广告视图：

```java
.setAdView(adView);
```

在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求会被处理。

当原生广告下载完成后，你可以通过调用`renderAdView()`方法显示广告。

To learn about download completion, subscribe to ad events (see [Ad events handling](#ad-events-handling) section) or call method `isReady()`.
```java
nativeAd.isReady();
```

### 自定义原生 UI

随着原生模版，您可以自定以下列元素：

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

为了定制这些元素，您需要构建一个属性对象，并在“NativeAd”的创建中提供以下内容：
```java
.setAdUnitId(AD_UNIT_ID)
.setAdViewBuilder(FeedCardNativeAdView.BUILDER)
.setAdViewAttributes(new NativeAdView.Attributes(this)
    .setTitle(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.Title>() {
        @Override
        public NativeAdView.Attributes.Title set(@NonNull NativeAdView.Attributes.Title builder) {
            return builder
                    .setTextFont(Typeface.MONOSPACE)
                    .setTextColor(Color.RED)
                    .setMaxEms(20);
        }
    })
    .setStarRating(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.StarRating>() {
        @Override
        public NativeAdView.Attributes.StarRating set(@NonNull NativeAdView.Attributes.StarRating builder) {
            return builder.setStarSize(Size.MEDIUM);
            }
        })
    .setAdAttribution(new NativeAdView.Attributes.Setter<NativeAdView.Attributes.AdAttribution>() {
        @Override
        public NativeAdView.Attributes.AdAttribution set(@NonNull final NativeAdView.Attributes.AdAttribution adAttribution) {
            return adAttribution.setDefaultText(R.string.sponsored);
        }
}))
```

此外，您可以使用以下属性设置`NativeAdView`布局的样式：

|属性名称| 格式 | 描述 |
|---|---|---|
| `Title` |
| avocarrotTitleTextFont | DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF | 标题文本的字体 |
| avocarrotTitleTextSize | reference,dimension | 标题文本的大小 |
| avocarrotTitleTextColor | reference,color | 标题文本的颜色|
| avocarrotTitleTextMaxLengthEms | integer | 标题文本的最大Ems|
| `Icon` |
| avocarrotIconWidth | reference,dimension | 图标视图宽度 |
| avocarrotIconHeight | reference,dimension |图标视图高度|
| avocarrotIconMarginLeft | reference,dimension | 图标查看左偏移|
| avocarrotIconMarginRight | reference,dimension | 图标查看右偏移|
| `Star Rating` |
| avocarrotStarRatingSize | SMALL, MEDIUM, LARGE | 评级栏星星的尺寸。 SMALL  -  10dp （高度和宽度），中 -  16dp，大 -  22dp|
| `Ad Attribution` |
| avocarrotAdAttributionTextFont | DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF | 属性标签文字的字体 |
| avocarrotAdAttributionTextSize | reference,dimension | 广告属性文字的大小|
| avocarrotAdAttributionTextColor | reference,color | 广告属性文字的颜色|
| avocarrotAdAttributionDefaultText | reference,string | 默认广告属性文字|
| `Cover Image` |
| avocarrotCoverImageBackgroundColor | reference,color | 封面图象背景颜色|
| avocarrotCoverImageBackgroundResource | reference | 封面图片背景资源|
| avocarrotCoverImageMarginLeft | reference,dimension | 封面图像左偏移|
| avocarrotCoverImageMarginRight | reference,dimension | 封面图像右偏移|
| avocarrotCoverImageMarginTop | reference,dimension | 封面图像顶偏移|
| avocarrotCoverImageMarginBottom | reference,dimension | 封面图像底偏移|
| avocarrotCoverImageAlignment | undefine, top, bottom, left, right, center, center_vertical, center_horizontal | 原生广告视图中的封面对齐|
| `Description` |
| avocarrotDescriptionTextFont | DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF | 描述文字的字体 |
| avocarrotDescriptionTextSize | reference,dimension | 描述文字的字体的大小|
| avocarrotDescriptionTextColor | reference,color | 描述文字的字体的颜色|
| avocarrotTitleTextMaxLengthEms | integer | 描述文字的最大Ems|
| avocarrotDescriptionMarginLeft | reference,dimension | 描述视图左偏移|
| avocarrotDescriptionMarginRight | reference,dimension | 描述视图右偏移|
| `Call To Action` |
| avocarrotCallToActionBackgroundColor |  reference,color | Call To Action操作按钮的颜色 |
| avocarrotCallToActionTextFont | DEFAULT, DEFAULT_BOLD, MONOSPACE, SANS_SERIF, SERIF | Call To Action文字的字体|
| avocarrotCallToActionTextSize | reference,dimension | Call To Action文字的字体的大小|
| avocarrotCallToActionTextColor | reference,color | Call To Action文字的字体的颜色|
| avocarrotCallToActionMarginLeft | reference,dimension | Call To Action文字的字体的左偏移|
| avocarrotCallToActionMarginRight | reference,dimension | Call To Action文字的字体的右偏移|
| avocarrotCallToActionMarginTop | reference,dimension | Call To Action文字的字体的顶偏移|
| avocarrotCallToActionMarginBottom | reference,dimension | Call To Action文字的字体的底偏移|
| avocarrotCallToActionDefaultText | reference,string | 默认Call To Action文字|

You can set this attributes in your custom `NativeAdView` layout
``` xml
<com.avocarrot.sdk.nativead.NativeAdView android:id="@+id/native_ad"
    app:avocarrotTitleTextFont="MONOSPACE"
    app:avocarrotIconWidth="42dp"
    app:avocarrotIconHeight="42dp"
    app:avocarrotCallToActionTextColor="@android:color/lighter_gray"
 ...>
```

### ListView ###

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

请在您的Activity里添加以下代码：

```java
StreamAdAdapter adAdapter = new StreamAdAdapter.Builder()
  .setAdapter(new MainAdapter(this))
  .setAdUnitId("YOUR_NATIVE_AD_UNIT_ID")
  .setViewBuilder(FeedCardNativeAdView.BUILDER)
  .setStreamNativeAdCallback(this)
  .build(this);
listView.setAdapter(adAdapter);
adAdapter.loadAd();
```

#### RecyclerView ####

```java
RecyclerAdAdapter adAdapter = new RecyclerAdAdapter.Builder()
  .setAdapter(new MainAdapter(this))
  .setAdUnitId("YOUR_NATIVE_AD_UNIT_ID")
  .setViewBuilder(FeedCardNativeAdView.BUILDER)
  .setStreamNativeAdCallback(this)
  .build(this);
recyclerView.setLayoutManager(layoutManager);
recyclerView.setAdapter(adAdapter);
adAdapter.loadAd();
```
在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求会被处理。

当推送广告下载完成时，它将自动显示。

为了得知下载是否完成，订阅广告事件（请见 广告事件处理 章节）。


## 广告回调

为了从广告接收事件，你应当设置一个时间监听器接口AdEventCallback。

监听器示例：
```java
AdEventCallback adListener = new AdEventCallback() {
    @Override
    public void onAdLoaded() {
    }

    @Override
    public void onAdFailed(@NonNull final ResponseStatus responseStatus) {
    }

    @Override
    public void onAdOpened() {
    }

    @Override
    public void onAdClicked() {
    }

    @Override
    public void onAdClosed() {
    }

    @Override
    public void onAdCompleted() {
    }
};
```

## 活动生命周期

`onPause()`, `onResume()` 和 `onDestroy()` 方法应该根据活动生命周期事件来调用。

例如：
```java
@Override
protected void onPause() {
    super.onPause();
    interstitialAd.onActivityPaused();
    standardAd.onActivityPaused();
    videoAd.onActivityPaused();
    nativeAd.onActivityPaused();
}

@Override
protected void onResume() {
    super.onResume();
    interstitialAd.onActivityResumed();
    standardAd.onActivityResumed();
    videoAd.onActivityResumed();
    nativeAd.onActivityResumed();
}

@Override
protected void onDestroy() {
    super.onDestroy();
    interstitialAd.onActivityDestroyed();
    standardAd.onActivityDestroyed();
    videoAd.onActivityDestroyed();
    nativeAd.onActivityDestroyed();
}
```

## 广告平台测试设置  

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

## Demo（示例）应用/测试

### 步骤

1. 从GitHub下载Avocarrot Demo（示例）。
2. 在 **File > New > ImportProject** 下将Avocarrot Demo（示例应用程序）导入Android Studio。
3. 在Avocarrot用户界面中，将您要使用的广告单元 **的状态设置为** Test。
4. 在Avocarrot用户界面中，点击“Click to Copy Ad Unit ID”按钮将广告位置ID复制到剪贴板。
5. 在Android Studio中，在**您要使用的广告单**元的广告类型的JavaActivity中，粘贴步骤4中的广告单元ID。
6. 在Android Studio 主面中，选择**Run**，然后单击**Run**编译和运行应用程序。
7. 在使用Avocarrot运行应用程序的Android模拟器（或您的设备），从步骤4中选择广告类型，您将在Avocarrot Publishers的自助服务UI下的** Reporting**看到事件数据。

[有关详细SDK主题，请单击此处](CONFIGURATION.md)
