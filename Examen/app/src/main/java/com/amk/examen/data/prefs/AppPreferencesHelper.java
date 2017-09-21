package com.amk.examen.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.amk.examen.di.ApplicationContext;
import com.amk.examen.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by andresaleman on 9/21/17.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper
{
    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
}
