# cordova-plugin-progress-notification
Progress Notification for Android Cordova Plugin


## What is this?
A Cordova plugin which can be used to display progressive notification in android. like notification of file downloading or uploading.

## Installation
```bash
cordova plugin add https://github.com/bhavincb/cordova-plugin-progress-notification
```

Or

```bash
npm install cordova-plugin-progress-notification
cordova plugin add node_modules\cordova-plugin-progress-notification
```

## How can I use?
It's very simple, there are 4 self-explanatory methods:

all this methods can be used on global variable "progressNotification" which will be available after cordova device ready event is fired.

```javascript
progressNotification.show(id, tittle, message, indeterminate); // indeterminate is optional

progressNotification.update(id, value); // value can be 0-100

progressNotification.finish(id, message, value); // Default parameter value for this method is 100

progressNotification.dismiss(id); // Close notification
```
