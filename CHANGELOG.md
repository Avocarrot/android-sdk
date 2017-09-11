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
