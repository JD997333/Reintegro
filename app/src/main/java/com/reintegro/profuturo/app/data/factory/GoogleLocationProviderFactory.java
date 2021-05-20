package com.reintegro.profuturo.app.data.factory;

import android.content.Context;

import com.reintegro.profuturo.app.android.provider.GoogleLocationProvider;
import com.reintegro.profuturo.app.data.provider.LocationProvider;

public class GoogleLocationProviderFactory extends LocationProviderFactory{
    private Context context;

    public GoogleLocationProviderFactory(Context context) {
        this.context = context;
    }

    @Override
    public LocationProvider createLocationProvider() {
        return new GoogleLocationProvider(context);
    }
}
