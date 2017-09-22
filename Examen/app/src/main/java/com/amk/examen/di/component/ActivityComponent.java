package com.amk.examen.di.component;

import com.amk.examen.di.PerActivity;
import com.amk.examen.di.module.ActivityModule;
import com.amk.examen.ui.login.LoginActivity;
import com.amk.examen.ui.main.MainActivity;
import com.amk.examen.ui.main.categories.CategoriesFragment;
import com.amk.examen.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by andresaleman on 9/21/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent  {

    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(MainActivity activity);
    void inject(CategoriesFragment fragment);
}
