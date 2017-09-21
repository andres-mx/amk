package com.amk.examen.di.component;

import com.amk.examen.di.PerService;
import com.amk.examen.di.module.ServiceModule;
import com.amk.examen.service.SyncService;

import dagger.Component;

/**
 * Created by andresaleman on 9/21/17.
 */
@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
