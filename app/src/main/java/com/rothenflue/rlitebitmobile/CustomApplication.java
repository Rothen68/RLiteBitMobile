package com.rothenflue.rlitebitmobile;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.rothenflue.services.bdd.entities.LiteBitMobileDAO;

/**
 * Created by apest on 03/01/2018.
 */

public class CustomApplication extends Application {
    private static CustomApplication singleton;
    private static LiteBitMobileDAO daoService;

    public CustomApplication getInstance() {
        return singleton;
    }

    public LiteBitMobileDAO getDaoService() {
        return daoService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Stetho.initializeWithDefaults(this);
        daoService = new LiteBitMobileDAO(this);

    }
}
