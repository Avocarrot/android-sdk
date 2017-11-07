## Version 4.7.1 (November 7, 2017)
- Performance improvements
- Updated the following dependencies:
    - Facebook Audience Network SDK to 4.26.1
    - MoPub SDK to 4.18.0

## Version 4.7.0 (October 23, 2017)
- Removed Support Appcompat library dependency from `native-assets` module

## Version 4.6.2 (October 10, 2017)
- Removed VAST-module dependency from `mediation-sdk-native-assets`
- Updated the following dependencies:
    - Android Support Libraries to 26.1.0 
    - Google Play Services to 11.4.2
    - Facebook Audience Network SDK to 4.26.0
    - InLocoMedia SDK to 3.3.2
    - MoPub SDK to 4.17.0
    - UnityAds SDK to 2.1.1

## Version 4.6.1 (October 2, 2017)
- Bugfixing:
    - Crash on devices running Android 8.0 Oreo (API 26)
    - Vungle SDK proguard issue
    
## Version 4.6.0 (September 11, 2017)
- MREC banner size (300x250) support
- The minimum Android SDK version is increased to 14(Android 4.0 API/`ICE_CREAM_SANDWICH`)
- Fixed behaviour when NativeAd with Fullscreen Template doesn't send `onAdClosed(@NonNull NativeAd nativeAd)` callback
- Minor bugfixing
- Updated the following dependencies:
    - Android Support Libraries to 26.0.1 
    - Google Play Services to 11.2.0
    - Chartboost SDK to 7.0.0
    - InLocoMedia SDK to 3.2.1

## Version 4.5.1 (August 15, 2017)
- Methods `setEventCallback(StreamNativeAdCallback eventCallback)` of `StreamAdRecyclerAdapter.Builder` and 
`setNativeAdCallback(StreamNativeAdCallback eventCallback)` of `StreamAdBaseAdapter.Builder` are deprecated. 
Use `setStreamNativeAdCallback(StreamNativeAdCallback eventCallback)` instead
- Optimised battery power consumption
- Recycler view dependency is now included in `mediation-mopub-nativead` and `mediation-facebook` modules, and it was removed from `mediation-sdk-nativead` module
- Minor bugfixing
