package com.reintegro.profuturo.app.data.factory;


import com.reintegro.profuturo.app.data.provider.LocationProvider;

public abstract class LocationProviderFactory {
    public abstract LocationProvider createLocationProvider();
}
