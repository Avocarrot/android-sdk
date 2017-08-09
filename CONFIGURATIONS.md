# Avocarrot SDK Advanced Features

Here you can find advanced SDK topics.

## Contents

* [Avocarrot Support](#avocarrot-support)
* [User Data](#user-data)
* [Log](#log)
* [Debug Mode](#debug-mode)
* [Test Mode](#test-mode)
* [Eclipse Integration](#eclipse-integration)
* [Avoiding the 65K Limit](#avoiding-the-65k-limit)

## Avocarrot Support

Additional documentation for integrating the Avocarrot SDK with your Android app can be found by clicking the links. 

- [Avocarrot.com Tutorials](https://app.avocarrot.com/#/docs) - Tutorials and Sign Up to Avocarrot
- [Publisher's Self-Serve UI User Guide](https://app.avocarrot.com/#/docs/getting-started/android) - Publisher's Interface Guide
- [Avocarrot FAQ](https://app.avocarrot.com/#/docs/faq) - Support and FAQ

## User Data

To pass user data to the Avocarrot SDK, use the following static methods:
```java
Avocarrot.setUserBirthday(data);
Avocarrot.setUserGender(UserData.Gender.FEMALE);
Avocarrot.setUserInterests(Arrays.asList("football", "auto", "cats")); // Just for example. Please set real interests.
```

## Log

The default log level is INFO. From the adb shell, you can change the log level to DEBUG, VERBOSE etc. using this command:

```
setprop log.tag.Avocarrot_SDK DEBUG
```

```
setprop log.tag.MRAID DEBUG
```

```
setprop log.tag.VAST DEBUG
```

## Debug Mode

If you want to log debug information, please install ``Avocarrot.setDebugMode(true)`` (false by default), then you will see the logs under `Avocarrot_SDK` tag.
It is recommended that this option should be used for integration test purposes.

## Test Mode

If you want to check integration, please set ``Avocarrot.setTestMode(true)`` (false by default). All ad types will be switched to test mode.
If you need to check current state, please use ``Avocarrot.isTestMode()``.

## Eclipse Integration ##

Since Google [deprecated] (https://developer.android.com/studio/tools/sdk/eclipse-adt.html) the Eclipse support, we recommend to use Android Studio for the SDK integration.

### Avoiding the 65K Limit ###

If you receive a dex error while adding third party network SDKs and adapters, you may need to enable multidexing in your build.gradle file.

defaultConfig {
  ...
  multiDexEnabled true
  ...
}

Then in your manifest add the `MultiDexApplication` class from the multidex support library to the application element.:

```
<application
  ...
  android:name="android.support.multidex.MultiDexApplication">
  ...
</application>
```

Please see the Android documentation [here](https://developer.android.com/tools/building/multidex.html).

## More Information:

[To go to the basic SDK Integration, click here.](README.md)



