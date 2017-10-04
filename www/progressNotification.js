var exec = require('cordova/exec'),
    argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils');

module.exports = (function() {
  var _notification = {};

  _notification.show = function(title, message, indeterminate, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'show', [title, message, indeterminate || false]);
  }

  _notification.update = function(value, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'update', [value]);
  }

  _notification.finish = function(message, value, successCallback, errorCallback) {
    value = typeof(value) == 'undefined' ? 100 : value;
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'finish', [message, value]);
  }
  _notification.dismiss = function(value, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'dismiss', []);
  }

  return _notification;
}());