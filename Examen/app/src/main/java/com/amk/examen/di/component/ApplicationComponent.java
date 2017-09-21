package com.amk.examen.di.component;

import android.app.Application;
import android.content.Context;

import com.amk.examen.MvpApp;
import com.amk.examen.data.DataManager;
import com.amk.examen.di.ApplicationContext;
import com.amk.examen.di.module.ApplicationModule;
import com.amk.examen.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andresaleman on 9/21/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}