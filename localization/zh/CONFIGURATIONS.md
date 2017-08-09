# Avocarrot SDK Advanced Features

Here you can find advanced SDK topics.

## Contents

* [Avocarrot 支持](#avocarrot-支持)
* [用户数据](#用户数据)
* [日志](#日志)
* [调试模式](#调试模式)
* [Eclipse 集成](#eclipse-集成)
* [避免65k限制](#避免65k限制)

## Avocarrot 支持

通过单击链接可以找到有关将Avocarrot SDK与Android应用集成的其他文档。

- [Avocarrot.com Tutorials](https://app.avocarrot.com/#/docs) - 视频教程整合加注册
- [Publisher's Self-Serve UI User Guide](https://app.avocarrot.com/#/docs/getting-started/android) - 出版商界面
- [Zendesk Support](https://app.avocarrot.com/#/docs/faq) - 支持和常见问题

## 用户数据

将用户数据传递到Avocarrot SDK，请使用以下静态方法：
```java
Avocarrot.setUserBirthday(data);
Avocarrot.setUserGender(UserData.Gender.FEMALE);
Avocarrot.setUserInterests(Arrays.asList("football", "auto", "cats")); // Just for example. Please set real interests.
```

## 日志 

默认日志等级为INFO。从adb shell中，你可以使用此命令将日志等级改为DEBUG、VERBOSE等：

```
setprop log.tag.Avocarrot_SDK DEBUG
```

```
setprop log.tag.MRAID DEBUG
```

```
setprop log.tag.VAST DEBUG
```

## 调试模式

如果你希望记录日志调试信息，请安装 Avocarrot.setDebugMode(true) (默认为false)，然后你将在 Avocarrot_SDK 标签下看到日志。 建议将此选项用于整合测试。

## Eclipse 集成  ##

自google（已废弃） （ https://developer.android.com/studio/tools/sdk/eclipse-adt.html ） Eclipse的支持下，对于SDK整合我们建议使用Android Studio.

### 避免65k限制 ###

如果你在增加第三方网络SDK和适配器时收到一个dex错误，你可能需要在你的build.gradle文件中启用multidexing。

defaultConfig {
  ...
  multiDexEnabled true
  ...
}

然后在 manifest 里添加 multidex support library 的 MultiDexApplication 类到 application element:

```
<application
  ...
  android:name="android.support.multidex.MultiDexApplication">
  ...
</application>
```

请看 Android 文档 [这里](https://developer.android.com/tools/building/multidex.html).

## 更多信息  :
要转到基本SDK集成，请单击[这](Configurations.md)


