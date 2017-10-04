# cordova-plugin-progress-notification
Progress Notification for Android Cordova Plugin


## What is this?
![](https://developer.android.com/images/ui/notifications/progress_bar_summary.png)

https://developer.android.com/training/notify-user/display-progress.html

## Installation
```bash
cordova plugin add https://github.com/bhavincb/cordova-plugin-progress-notification
```

## How can I use?
It's very simple, there are 4 self-explanatory methods:

```javascript
progressNotification.show(tittle, message, indeterminate); // indeterminate is optional

progressNotification.update(value); // value can be 0-100

progressNotification.finish(message, value); // Default parameter value for this method is 100

progressNotification.dismiss(); // Close notification
```
