package com.amk.examen;

import android.app.Application;

import com.amk.examen.data.DataManager;
import com.amk.examen.di.component.ApplicationComponent;
import com.amk.examen.di.component.DaggerApplicationComponent;
import com.amk.examen.di.module.ApplicationModule;
import com.amk.examen.utils.AppLogger;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by andresaleman on 9/21/17.
 */

public class MvpApp extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
