package com.reintegro.profuturo.app.android.app;

import com.reintegro.profuturo.app.database.DataBase;

public class AndroidApplication extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        DataBase.init(this);
    }
}
