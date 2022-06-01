package com.example.antiescaper;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class Alarm extends BroadcastReceiver {
    public static void set(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),  100, pIntent);
    }

    //private final static String FILE = "location.txt";

    @Override
    public void onReceive(Context context, Intent intent) {
        Location loc = getLastLocation(context);
        String locationFile = context.getApplicationInfo().dataDir + "/location";

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(locationFile, Context.MODE_PRIVATE));
            outputStreamWriter.write(loc.getLatitude() + " " + loc.getLongitude());
            outputStreamWriter.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    Location getLastLocation(Context context) {
        LocationManager lManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        //int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        android.location.Location locationGPS = lManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        android.location.Location locationNet = lManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        long GPSLocationTime = 0;
        if (null != locationGPS) { GPSLocationTime = locationGPS.getTime(); }

        long NetLocationTime = 0;
        if (null != locationNet) { NetLocationTime = locationNet.getTime(); }

        Location loc;
        if ( 0 < GPSLocationTime - NetLocationTime ) {
            loc = locationGPS;
        } else {
            loc = locationNet;
        }

        if (loc != null) {
            return loc;
        } else {
            return null;
        }

    }
        /*FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE, MODE_PRIVATE);
            fos.write(+" " + loc.getLongitude());
        } catch (IOException ex) {

        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {

            }
        }*/

    /*public void send(Context context, Intent intent)
    {
        MyService LOC = new MyService();
        Location loc = LOC.getLastLocation(context);
        //String locationFile = context.getApplicationInfo().dataDir + "/location";

        /*try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(locationFile, Context.MODE_PRIVATE));
            outputStreamWriter.write(loc.getLatitude() + " " + loc.getLongitude);
            outputStreamWriter.close();
        }
        catch (IOException e)
    }*/

        /*try {
            FileOutputStream fos = new FileOutputStream("location.txt");
            fos.write(String.valueOf(loc.getAltitude()) + " " + String.valueOf(loc.getLongitude()));
        } catch (IOException ex) {

        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {

            }
        }*/
}

