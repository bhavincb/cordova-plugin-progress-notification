package cordova.plugin;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.R;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;


public class AndroidProgressNotification extends CordovaPlugin {
    private static final String TAG = "AndroidProgressNotification";
    private static final Integer MAX_VALUE = 100;

    private NotificationManager notificationManager;
    private android.support.v4.app.NotificationCompat.Builder builder;
    private boolean indeterminate;

    private NotificationManager getNotificationManager() {
        if (this.notificationManager == null) {
            this.notificationManager = (NotificationManager) this.cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return this.notificationManager;
    }

    private android.support.v4.app.NotificationCompat.Builder getBuilder() {
        if (this.builder == null) {
            this.builder = new NotificationCompat.Builder(this.cordova.getActivity()).setSmallIcon(this.cordova.getActivity().getApplicationInfo().icon);
        }

        return this.builder;
    }

    private void updateOrShow(Integer id) {
        getNotificationManager().notify(id, this.getBuilder().build());
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show")) {
			Integer id = args.getInt(0);
            String title = args.getString(1);
            String text = args.getString(2);
            this.indeterminate = args.getBoolean(3);

            this.getBuilder()
                    .setContentTitle(title)
                    .setContentText(text)
                    .setProgress(MAX_VALUE, 0, indeterminate)
                    .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
					.setSmallIcon(this.cordova.getActivity().getApplicationInfo().icon)
                    .setOngoing(true);

            this.updateOrShow(id);

            callbackContext.success();
        }

        if (action.equals("update")) {
			Integer id = args.getInt(0);
            Integer value = args.getInt(1);
            getBuilder()
                .setProgress(MAX_VALUE, value, indeterminate);
            this.updateOrShow(id);

            callbackContext.success();
        }

        if (action.equals("finish")) {
			Integer id = args.getInt(0);
            Integer value = args.getInt(2);
            getBuilder()
                .setContentText(args.getString(1))
                .setProgress(MAX_VALUE, value, false)
                .setOngoing(false);
            this.updateOrShow(id);
            this.builder = null;

            callbackContext.success();
        }

        if (action.equals("dismiss")) {
			Integer id = args.getInt(0);
            this.getNotificationManager().cancel(id);
            this.builder = null;

            callbackContext.success();
        }


        return true;
   }

   /*  @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        if (this.builder != null) {
            updateOrShow();
        }

    } */
}