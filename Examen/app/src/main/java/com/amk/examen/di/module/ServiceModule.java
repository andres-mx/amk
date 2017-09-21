package com.amk.examen.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by andresaleman on 9/21/17.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
