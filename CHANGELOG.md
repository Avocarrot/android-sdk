## Version 4.5.1 (August 15, 2017)
- Methods `setEventCallback(StreamNativeAdCallback eventCallback)` of `StreamAdRecyclerAdapter.Builder` and 
`setNativeAdCallback(StreamNativeAdCallback eventCallback)` of `StreamAdBaseAdapter.Builder` are deprecated. 
Use `setStreamNativeAdCallback(StreamNativeAdCallback eventCallback)` instead
- Optimised battery power consumption
- Recycler view dependency is now included in `mediation-mopub-nativead` and `mediation-facebook` modules, and it was removed from `mediation-sdk-nativead` module
- Minor bugfixing
