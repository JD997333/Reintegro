package com.reintegro.profuturo.app.android.converter;

import android.location.Location;

import com.reintegro.profuturo.app.data.entity.LocationEntity;

public class LocationConverter {
    public static LocationEntity convert(Location source) {
        LocationEntity entity = new LocationEntity();
        entity.setAltitude(source.getAltitude());
        entity.setLatitude(source.getLatitude());
        entity.setLongitude(source.getLongitude());

        return entity;
    }
}
