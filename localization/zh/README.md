[Português](localization/pt/README.md)

# Avocarrot SDK 集成 

现在就开启您的收入新渠道！尽在：[Avocarrot.com](https://avocarrot.com)

## Contents

* [Avocarrot支持](#avocarrot支持)
* [平台和广告类支持](#平台和广告类支持)
* [需求和依赖](#需求和依赖)
* [添加AvocarrotSDK和第三方平台到项目](#添加avocarrotSDK和第三方平台到项目)
* [更新Android Manifest](#更新android-manifest)
* [标准横幅广告初始化和活动](#标准横幅广告初始化和活动)
* [插屏广告初始化和活动](#插屏广告初始化和活动)
* [视频广告初始化和活动](#视频广告初始化和活动)
* [原生广告资产Native Assets](#原生广告资产Native-Assets)
* [原生和Feed广告，模版和UI](#原生和feed广告模版和ui)
* [广告回调](#广告回调)
* [活动生命周期](#活动生命周期)
* [广告平台测试设置](#广告平台测试设置)
* [Demo（示例）应用/测试](#demo示例应用测试)

## Avocarrot支持

通过单击链接可以找到有关将Avocarrot SDK与Android应用集成的其他文档。

- [Avocarrot.com Tutorials](https://app.avocarrot.com/#/docs) - 视频教程整合加注册
- [Publisher's Self-Serve UI User Guide](https://app.avocarrot.com/#/docs/getting-started/android) - 出版商界面
- [Avocarrot FAQ](https://app.avocarrot.com/#/docs/faq) - 技术支持和常见问题

## 支持的平台和广告类型 ##

Avocarrot 在客户端一侧支持以下广告平台：

为了显示标准横幅广告：

| 名称  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-banner`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.6.2, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-banner`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.18.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-banner`| [Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.26.0, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-inlocomedia-banner`| [InLocoMedia](http://docs.inlocomedia.com)| v3.3.10, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

为了显示插屏广告：

| 名称  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-interstitial`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.6.2, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-interstitial`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.18.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-chartboost-interstitial`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v7.0.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-facebook-interstitial`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.26.1, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-nativex-interstitial`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-applovin-interstitial`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-interstitial`| [InLocoMedia](http://docs.inlocomedia.com)| v3.3.10, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

为了显示视频广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-unityads-video`|[Unity Ads](https://github.com/Applifier/unity-ads-sdk)|v2.1.1, API 9: Android 2.3 (Gingerbread)|
|`mediation-chartboost-video`|[Chartboost](https://answers.chartboost.com/hc/en-us/articles/201219545-Download-Integrate-the-Chartboost-SDK-for-Android)|v7.0.0, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-nativex-video`|[NativeX](https://github.com/nativex/NativeX-Android-SDK)|v5.5.9, API 11: Android 3.0 (Honeycomb)|
|`mediation-vungle-video`|[Vungle](https://v.vungle.com/sdk)|v4.1.0, API 14: Android 4.0 (Ice Cream Sandwich)|

为了显示原生广告：

| 特定  | 平台  | 版本  |
|----------|----------|----------|
|`mediation-admob-nativead`|[Google Mobile Ads](https://developers.google.com/admob/android/quick-start)|v11.6.2, API 14: Android 4.0 (Ice Cream Sandwich)|
|`mediation-mopub-nativead`|[MoPub](https://github.com/mopub/mopub-android-sdk)|v4.18.0, API 16: Android 4.1 (JELLY_BEAN)|
|`mediation-facebook-nativead`|[Facebook Audience](https://developers.facebook.com/docs/audience-network)|v4.26.1, API 15: Android 4.0.3 (ICE_CREAM_SANDWICH_MR1)|
|`mediation-applovin-nativead`|[AppLovin](https://github.com/AppLovin/Android-Demo-App)|v7.0.3, API 9: Android 2.3 (Gingerbread)|
|`mediation-inlocomedia-nativead`| [InLocoMedia](http://docs.inlocomedia.com)| v3.3.10, API 14: Android 4.0 (ICE_CREAM_SANDWICH)|

> 如果您使用其他版本的网络库，我们就不能保证SDK的最佳稳定性。

您必须在Avocarrot网站上设置每个第三方平台，否则它们不会用于展示广告。

## 需求和依赖 ##

* Android 4.0 (API Version 14) and up
* support-annotations, v27.0.2
* support-v4, v27.0.2
* **推荐** Google Play Services 11.6.2

我们强烈建议使用 **Google Play services** 编译你的app，从而按照Google的要求使用 `Android Advertising ID` 代替 `Device ID` 。没有正确使用 `Android Advertising ID` 可能导致你向Play Store的提交被拒绝。

>提示:对于在您应用中的每一个广告位，您都需要有一个不同的 **adUnitId** 。如果您对于不同广告位使用相同的ID，或者使用的测试时的ID，将会出现报告错误并且不会支付。如有问题，请联系您的客户经理。

## 添加AvocarrotSDK和第三方平台到项目 ##
可通过以下方式获取Avocarrot SDK ：

1. jCenter AAR (**Recommended**)
2. Zipped AAR

在您的 _app_ 模块中 `build.gradle` 文件中增加以下代码：

```
repositories {
  maven { url "https://s3.amazonaws.com/moat-sdk-builds" } // required by mopub (more info: https://github.com/mopub/mopub-android-sdk#download)
  maven { url "https://s3.amazonaws.com/avocarrot-android-builds/dist/" }
}

dependencies {
  compile 'com.avocarrot.sdk:mediation-sdk-banner:4.7.2'
  compile 'com.avocarrot.sdk:mediation-sdk-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-sdk-video:4.7.2'
  compile 'com.avocarrot.sdk:mediation-sdk-nativead:4.7.2'
  //3rd party SDKs if you need. Don't need to corresponding mediation-sdk module
  compile 'com.avocarrot.sdk:mediation-admob-banner:4.7.2'
  compile 'com.avocarrot.sdk:mediation-admob-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-admob-nativead:4.7.2'
  compile 'com.avocarrot.sdk:mediation-applovin-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-applovin-nativead:4.7.2'
  compile 'com.avocarrot.sdk:mediation-chartboost-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-facebook-banner:4.7.2'
  compile 'com.avocarrot.sdk:mediation-facebook-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-facebook-nativead:4.7.2'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-banner:4.7.2'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-inlocomedia-nativead:4.7.2'
  compile 'com.avocarrot.sdk:mediation-mopub-banner:4.7.2'
  compile 'com.avocarrot.sdk:mediation-mopub-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-mopub-nativead:4.7.2'
  compile 'com.avocarrot.sdk:mediation-nativex-interstitial:4.7.2'
  compile 'com.avocarrot.sdk:mediation-nativex-video:4.7.2'
  compile 'com.avocarrot.sdk:mediation-unityads-video:4.7.2'
  compile 'com.avocarrot.sdk:mediation-vungle-video:4.7.2'

  compile 'com.google.android.gms:play-services-ads:11.6.2'
}
```

### 添加本地 .aar libraries ###

将 aar 文件保存在 app module's libs 文件夹下 (例如： <project>/<app>/libs)

然后在your app module build.gradle 文件中增加以下行：

```
repositories {
  maven { url "https://s3.amazonaws.com/moat-sdk-builds" } // required by mopub (more info: https://github.com/mopub/mopub-android-sdk#download)
  flatDir {
    dirs 'libs'
  }
}

dependencies {
  compile(name: 'core', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-sdk', version:'4.7.2', ext: 'aar')
    
    //To use Native Assets only 
    compile(name: 'mediation-sdk-native-assets', version:'4.7.2', ext: 'aar')
    
    //To use Banners and Interstitials
    compile(name: 'mediation-sdk-mraid', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-sdk-banner', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-sdk-interstitial', version:'4.7.2', ext: 'aar')
    
    //To use Video and Native Ads
    compile(name: 'mediation-sdk-vast', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-sdk-video', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-sdk-nativead', version:'4.7.2', ext: 'aar')
    
    //3rd party SDKs
    compile(name: 'mediation-admob', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-admob-banner', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-admob-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-admob-nativead', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-applovin', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-applovin-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-applovin-nativead', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-chartboost', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-chartboost-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-facebook', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-facebook-banner', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-facebook-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-facebook-nativead', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-inlocomedia', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-inlocomedia-banner', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-inlocomedia-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-inlocomedia-nativead', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-mopub', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-mopub-banner', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-mopub-interstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-mopub-nativead', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-nativex', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-nativex-inerstitial', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-nativex-video', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-unityads', version:'4.7.2', ext: 'aar')
    compile(name: 'mediation-unityads-video', version:'4.7.2', ext: 'aar'
    compile(name: 'mediation-vungle', version:'4.7.2', ext: 'aar'))
    compile(name: 'mediation-vungle-video', version:'4.7.2', ext: 'aar')
  
    compile 'com.google.android.gms:play-services-ads:11.6.2'
    compile 'com.facebook.android:audience-network-sdk:4.26.1'
    compile('com.mopub:mopub-sdk-banner:4.18.0@aar') {
      transitive = true
    }
    compile('com.mopub:mopub-sdk-interstitial:4.18.0@aar') {
        transitive = true
    }
    compile('com.mopub:mopub-sdk-native-static:4.18.0@aar') {
          transitive = true
    }
    compile 'com.inlocomedia.android:android-sdk:3.3.1'
}
```

然后在您的app module `proguard-rules.pro` 文件中添加以下的下行：

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
* ACCESS_COARSE_LOCATION (推荐) - 给予SDK权限，使其能获取基于当地基站的地址.
* ACCESS_FINE_LOCATION (推荐) - 给予SDK权限，使其能够获取基于当地GPS信息的地址.

尽管技术上没有要求，LOCATION许可使SDK能够向广告商发送基于位置的数据。发送更好的位置数据通常会带来更好的经济效益。

* WRITE_EXTERNAL_STORAGE (可选) - 允许SDK将所有的有用广告数据（创新、用户框架、等等）缓存在外部存储器。这就能通过确保立即投放广告使效果最大化，并通过使缓存的广告数据可用（即使在用户关闭app之后），尽量减少SDK使用的网络流量。

* READ_PHONE_STATE（推荐） - 允许SDK处理视频期间的电话中断视频回放。

当将SDK作为库工程使用时，你无需担心合并AndroidManifest.xml变动或Proguard设置。如果你遇到问题，确保在project.properties中将manifestmerger.enabled设置为true。

请看Android[文档](https://developer.android.com/studio/build/shrink-code.html).

## 标准横幅广告初始化和活动 ##

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
BannerAd bannerAd = BannerAdPool.load(this, "YOUR_BANNER_AD_UNIT_ID", adView, BannerSize.BANNER_SIZE_320x50, bannerAdListener);
```

可用尺寸：

* BannerSize.BANNER_SIZE_320x50 for 320x50 size
* BannerSize.BANNER_SIZE_300x250 for 300x250 size (MREC)
* BannerSize.BANNER_SIZE_728x90 for 728x90 size

### 标准横幅自动更新

您可以打开或关闭横幅广告的自动更新功能；为此，调用 `setAutorefreshEnabled()` 方法，例如
```java
standardAd.setAutorefreshEnabled(false);
```

在默认情况下，自动更新打开。通过管理员面板设置自动更新时段。

如果你需要手动再装横幅广告，调用：
```java
bannerAd.reloadAd();
```

## 插屏广告初始化和活动 ##

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

### 插屏广告初始化

请在您的Activity里添加以下代码：
```java
InterstitialAd interstitialAd = InterstitialAdPool.load(this, "YOUR_INTERSTITIAL_AD_UNIT_ID", interstitialAdListener);
```
在调用 `loadAd()` 方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用 `loadAd()` ，则新的请求处理就被忽略。在这种情况下，只有最后一个请求才会生效。

当插屏广告下载完成后，你可以通过调用`showAd()`方法显示插屏广告。
```java
interstitialAd.showAd();
```

为了得知下载是否完成，订阅插屏广告事件（ 请见[AD广告回调](#AD广告回调) ）或调用方法`isReady()`。
```java
interstitialAd.isReady();
```

如果需要手动加载插屏广告，请调用：
```java
interstitialAd.reloadAd();
```

如果你想要完全控制全屏插屏广告显示的时间和位置，使用以下步骤：

1. 设置 `InterstitialAdCallback` 来处理插屏广告事件
2. 提前调用 `interstitialAd.loadAd()`
3. 当你想展示插屏广告时，检测其是否准备好: `if (interstitialAd.isReady()) interstitialAd.showAd()`
4. 在AdEventCallback的事件处理器 onAdClosed()中开始加载下一个插屏广告。

## 视频广告初始化和活动 ##

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

### 视频广告初始化

请在您的Activity里添加以下代码：
```java
VideoAd videoAd = VideoAdPool.load(this, "YOUR_VIDEO_AD_UNIT_ID", closeButtonEnabled, videoAdListener);
```

部分网络支持视频广告中的 *关闭* 按钮。你可以通过改变 `closeButtonEnabled` 参量的值来实现:

如果在视频展示前您调用了 `reloadAd()` ，那么新的进程将被取消掉。只有一个请求会被处理。

档视频下载完成时，您可以通过调用 `showAd()` 方法来展示:
```java
videoAd.showAd();
```

为了得知下载是否完成，订阅视频广告事件（ 请见[AD广告回调](#AD广告回调) ）或调用方法`isReady()`。
```java
videoAd.isReady();
```

## 原生广告资产Native Assets##

我们的原生广告是没有任何前置UI包装的原始广告。广告的实际布局是由我们的工程师将原始广告转化而来的。

> 注意:若要使用原生广告，请在Avocarrot UI中选择原生类型。当前的原生广告并不支持如Admob, Facebook, Mopub等其他mediation network.

请在您的Activity中添加如下代码:
```java
NativeAssetsAd nativeAssetsAd = NativeAssetsAdPool.load(context, "YOUR_NATIVE_AD_UNIT_ID", nativeAssetsAdListener);
```

为了读取图片源，您可以在 `Builder` 中的 `NativeAssetsAd` 中，添加如下代码:
```java
final NativeAssetsConfig.Builder config = new NativeAssetsConfig.Builder()
       .prefetchIcon(true)
       .prefetchImage(true)
       .prefetchAdChoiceIcon(true);

nativeAssetsAd = NativeAssetsAdPool.load(this, getAdUnitId(), config, this);
```

或者，若您在 `onAdLoaded` 回调中获取 `NativeAssets` 的话，您也可以自行管理资源的下载:
```java
    public void onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets) {
        Image icon = nativeAssets.getIcon();
        if (icon != null) {
            String iconUrl = icon.getUrl();
            /* your image downloading code here */
        }
    }
```

当您配置一个原生广告时，以下是其常见的流程:
1. 建立一个 `View` 的子类，它将被用作广告的视图容器(view container)
2. 通过 `NativeAssetsAdPool.load(context, "YOUR_NATIVE_AD_UNIT_ID", nativeAssetsAdListener);` 来初始化 `NativeAssetsAd` 调用读取目录
3. 在 `onAdLoaded(@NonNull NativeAssetsAd nativeAssetsAd, @NonNull NativeAssets nativeAssets)` callback of `nativeAssetsAdListener` 中获取 `NativeAssets` 回调 `nativeAssetsAdListener`
4. 呈现广告的视图容器
5. 注册广告视图的查看次数和点击次数
    - 通过调用 `nativeAssetsAd.registerViewForImpression(adContainer)` 来注册AdChoice视图以完成展示(impression);
    - 通过调用 `.registerViewsForClick(clickableViewList)` 来注册广告视图的点击事件; 
    - 通过调用 `.registerAdChoiceViewForClick(adChoiceView)` 来注册AdChoice视图
6. 当你不再展示广告的时候，通过调用 `.unregisterViews()` 取消注册广告视图
7. 当你不再需要它的时候，通过调用 `.destroy()` 来摧毁 `NativeAssetsAd` 

举例如下:

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


## 原生和Feed广告，模版和UI ##

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

原生广告通过 `NativeAd` 类加载。 `NativeAdView` 是 `ViewGroup` 的子类，提供 `NativeAd` 的展示功能。 为配置 `NativeAdView` ，你可以通过修改 `NativeAdView.Builder` 和 `NativeAdView.Attributes` 来实现其自定义：

```java
NativeAd nativeAd = NativeAdPool.load(context, YOUR_NATIVE_AD_UNIT_ID, ListNativeAdView.BUILDER, nativeAdListener);
```

为了展示原生广告，你可以使用两种方法：

* 通过编程方法从模板创建一个广告视图，并将其加入到屏幕。
* 在布局中增加 NativeAdView 视图，并将加载的数据捆绑到此视图。

### 模板

Avocarrot SDK 对原生广告提供了三类模板

* FeedNativeAdView - 图标、标题、说明、星级评定和CTA按钮
* ListNativeAdView - 图像、图标/视频/图片轮播、标题、说明、星级评定、和CTA按钮
* GridNativeAdView - 在 `StreamAdRecyclerAdapter` 和 `GridLayoutManager` 中使用的特殊模板。 当前仅支持带有两列的`RecyclerView` 。
* DynamicNativeAdView - 在Avocarrot Dashboard中，为使用Template Service的特殊模板
* FullscreenNativeAdView - 全屏模板以使您的原生广告看起来像插屏广告。只在您使用单独的 `NativeAd` 时可用。

> 每一个模板具有一个标签，清晰的标明了这是一个广告。例如"Ad" 或"Sponsored"。

如果您希望使用模板之一，你可以在NativeAd创建时增加所选的模板： `NativeAd`:

```java
.setAdViewBuilder(ListNativeAdView.BUILDER);
```

对布局增加一个横幅广告位置，例如：
``` xml
  <FrameLayout
    android:id="@+id/ad_container"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:visibility="gone"/>
```

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

定制布局 `.xml`。例如：

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

在调用`loadAd()`方法之后，广告下载会立刻开始。如果您在广告被完全处理之前再次调用`loadAd()`，则新的请求处理就被忽略。在这种情况下，只有最后一个请求会被处理。

当原生广告下载完成后，您可以订阅广告事件(请查看[广告回调](#广告回调))。
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

为了定制这些元素，您需要构建一个属性对象，并在 `NativeAd` 的创建中提供以下内容：
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

### Feed 视图 ###

> 注意：所有SDK方法调用都应当从主线程进行（主线程，UI线程）。

请在您的Activity里添加以下代码：

#### ListView ####

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

为了得知下载是否完成，订阅广告事件（请见 [AD广告回调](#AD广告回调)）。


## 广告回调

为了从广告接受事件, 您应当设置一个事件监听接口:

对于 `BannerAd`: 
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

同样类似于 `InterstitialAdCallback` 之于 `InterstitialAd`.

对于 `VideoAd` 和 `NativeAd` 的回调接口来说同样类似，只是对于视频(广告)重放的实现，有(以下)额外的调用:  
```java
NativeAdCallback nativeAdListener = new NativeAdCallback() {
    
    ...
    
    @Override
    public void onAdCompleted(@NonNull NativeAd ad) {
    }
};
```

为了 `NativeAssetsAd` 你会收到一个带有原始原生广告数据的 `NativeAssets` 对象:
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

## 活动生命周期

`onActivityResumed()`, `onActivityPaused()` 和 `onActivityDestroyed()` ，这些方法应该基于其生命周期调用。

例如：
```java
@Override
protected void onResume() {
    super.onResume();
    interstitialAd.onActivityResumed();
    bannerAd.onActivityResumed();
    videoAd.onActivityResumed();
}

@Override
protected void onPause() {
    super.onPause();
    interstitialAd.onActivityPaused();
    bannerAd.onActivityPaused();
    videoAd.onActivityPaused();
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
## 广告网络设置 

如果你设置测试模式(TEST MODE)时带有: `Avocarrot.setTestMode(true)`  ，那么所有的 `HASHED_ID` 都将被自动设置

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
3. 在Avocarrot用户界面中，将 **您要使用的广告单元** 的状态设置为 Test。
4. 在Avocarrot用户界面中，点击"Click to Copy Ad Unit ID"按钮将广告位置ID复制到剪贴板。
5. 在Android Studio中，在 **您要使用的广告单元** 的广告类型的JavaActivity中，粘贴步骤4中的广告单元ID。
6. 在Android Studio 主面中，选择 **Run** ，然后单击 **Run** 编译和运行应用程序。
7. 当您在Android模拟器（或您的设备）下运行Avocarrot相关的App时，从步骤4中选择广告类型，您将在Avocarrot Publishers的自助服务UI下的 **Reporting** 看到事件数据。

[有关详细SDK主题，请单击此处](https://github.com/Avocarrot/android-sdk/blob/master/CONFIGURATIONS.md)
