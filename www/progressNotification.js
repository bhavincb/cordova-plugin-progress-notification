var exec = require('cordova/exec'),
    argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils');

module.exports = (function() {
  var _notification = {};

  _notification.show = function(id, title, message, indeterminate, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'show', [id, title, message, indeterminate || false]);
  }

  _notification.update = function(id, value, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'update', [id, value]);
  }

  _notification.finish = function(id, message, value, successCallback, errorCallback) {
    value = typeof(value) == 'undefined' ? 100 : value;
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'finish', [id, message, value]);
  }
  _notification.dismiss = function(id, value, successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'AndroidProgressNotification', 'dismiss', [id ]);
  }

  return _notification;
}());