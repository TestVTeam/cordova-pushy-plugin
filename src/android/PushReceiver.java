package com.lokesh.CDVpushyMe.plugin;

import com.plugin.gcm.PushHandlerActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class PushReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        //-----------------------------
        // Create a test notification
        //
        // (Use deprecated notification
        // API for demonstration purposes,
        // to avoid having to import
        // the Android Support Library)
        //-----------------------------

        String notificationTitle = "Pushy";
        String notificationDesc = "Test notification";

        //-----------------------------
        // Attempt to grab the message
        // property from the payload
        //
        // We will be sending the following
        // test push notification:
        //
        // {"message":"Hello World!"}
        //-----------------------------

        if ( intent.getStringExtra("message") != null )
        {
        	notificationTitle= intent.getStringExtra("sender");
            notificationDesc = intent.getStringExtra("message");
        }

        //-----------------------------
        // Create a test notification
        //-----------------------------
        
        int defaults = Notification.DEFAULT_ALL;		
        Intent notificationIntent = new Intent(context, org.dadabhagwan.AKonnect.MainActivity.class);
        //Intent notificationIntent = new Intent(this, org.dadabhagwan.AKonnect.MainActivity.class);
		notificationIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		        
        NotificationManager nmgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context)
        .setDefaults(defaults)
        .setContentTitle(notificationTitle)
        .setContentText(notificationDesc)
        .setWhen(System.currentTimeMillis())
        .setSmallIcon(context.getResources().getIdentifier("secondary_icon", "drawable", context.getPackageName()))
        .setContentIntent(contentIntent)
        .build();
        
        int id = (int) System.currentTimeMillis();
        nmgr.notify(id,notification);

//        Notification notification = new Notification(android.R.drawable.ic_dialog_info, notificationDesc, System.currentTimeMillis());
//
//        //-----------------------------
//        // Sound + vibrate + light
//        //-----------------------------
//
//        notification.defaults = Notification.DEFAULT_ALL;
//
//        //-----------------------------
//        // Dismisses when pressed
//        //-----------------------------
//
//        notification.flags = Notification.FLAG_AUTO_CANCEL;
//
//        //-----------------------------
//        // Create pending intent
//        // without a real intent
//        //-----------------------------
//
//        notification.setLatestEventInfo(context, notificationTitle, notificationDesc, null);
//
//        //-----------------------------
//        // Get notification manager
//        //-----------------------------
//
//        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        //-----------------------------
//        // Show the notification
//        //-----------------------------
//
//        mNotificationManager.notify(0, notification);
    }
}