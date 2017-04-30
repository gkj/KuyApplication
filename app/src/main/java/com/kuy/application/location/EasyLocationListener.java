package com.kuy.application.location;

import android.location.Location;

public interface EasyLocationListener {
    void onLocationPermissionGranted();
    void onLocationPermissionDenied();
    void onLocationReceived(Location location);
    void onLocationProviderEnabled();
    void onLocationProviderDisabled();
}