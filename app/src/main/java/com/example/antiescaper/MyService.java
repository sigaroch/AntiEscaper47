package com.example.antiescaper;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;

import androidx.core.content.ContextCompat;

public class MyService extends Service {
    public MyService() {

    }
    private final static String FILE = "app.txt";

    @Override
    public void onCreate() {
        super.onCreate();
        Alarm.set(this);
        /*Location loc = getLastKnownLocation(context);
        String locationFile = context.getApplicationInfo().dataDir + "/location";

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(locationFile, Context.MODE_PRIVATE));
            outputStreamWriter.write(loc.getLatitude() + " " + loc.getLongitude);
            outputStreamWriter.close();
        }
        catch (IOException e) {}*/
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }
    /*Location getLastLocation(Context context) {
        LocationManager lManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
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
    /*void dumpSMS(Context context) {
        String appsFile = context.getApplicationInfo().dataDir + "/apps";

        final PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        String INFO="";
        FileOutputStream fos = null;


        try {
            PrintWriter pw = Files.writeLines(appsFile);
            fos = openFileOutput(FILE, MODE_PRIVATE);

            for (ApplicationInfo packageInfo : packages) {
                if (!isSystemPackage(packageInfo))
                INFO+=pm.getApplicationLabel(packageInfo) + ": " + packageInfo.packageName;
                    pw.println(pm.getApplicationLabel(packageInfo) + ": " + packageInfo.packageName);
            }

            pw.close();
        } catch (IOException e) {}
    }

    private boolean isSystemPackage(ApplicationInfo applicationInfo) {
        return ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }*/

}
