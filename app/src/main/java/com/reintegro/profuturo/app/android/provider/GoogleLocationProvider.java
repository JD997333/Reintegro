package com.reintegro.profuturo.app.android.provider;

import android.annotation.SuppressLint;
import android.content.Context;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import com.reintegro.profuturo.app.android.converter.LocationConverter;
import com.reintegro.profuturo.app.data.entity.LocationEntity;
import com.reintegro.profuturo.app.data.provider.LocationProvider;

public class GoogleLocationProvider implements LocationProvider {
    private FusedLocationProviderClient fusedLocationProviderClient;

    public GoogleLocationProvider(Context context) {
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    }

    @SuppressLint("MissingPermission")
    public void getLastLocation(Subscriber<LocationEntity> subscriber) {
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                subscriber.onSuccess(LocationConverter.convert(location));
            } else {
                getLocationUpdates(subscriber);
            }
        });
    }

    @SuppressLint("MissingPermission")
    public void getLocationUpdates(Subscriber<LocationEntity> subscriber) {
        LocationRequest locationRequest;
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        Task<Void> task;
        task = fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    subscriber.onSuccess(LocationConverter.convert(locationResult.getLocations().get(0)));
                }
            },
            null
        );
        task.addOnFailureListener(exception -> {
            subscriber.onError(exception);
        });
    }

    @Override
    public void subscribe(Subscriber<LocationEntity> subscriber) {
        getLastLocation(subscriber);
    }
}
