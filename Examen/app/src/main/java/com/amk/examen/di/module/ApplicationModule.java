package com.amk.examen.di.module;

import android.app.Application;
import android.content.Context;

import com.amk.examen.R;
import com.amk.examen.data.AppDataManager;
import com.amk.examen.data.DataManager;
import com.amk.examen.data.db.AppDbHelper;
import com.amk.examen.data.db.DbHelper;
import com.amk.examen.data.network.ApiHelper;
import com.amk.examen.data.network.AppApiHelper;
import com.amk.examen.data.prefs.AppPreferencesHelper;
import com.amk.examen.data.prefs.PreferencesHelper;
import com.amk.examen.di.ApplicationContext;
import com.amk.examen.di.DatabaseInfo;
import com.amk.examen.di.PreferenceInfo;
import com.amk.examen.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by andresaleman on 9/21/17.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
