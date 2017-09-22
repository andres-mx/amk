package com.amk.examen.data.prefs;

import com.amk.examen.data.DataManager;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface PreferencesHelper
{
    int getCurrentUserLoggedInMode();
    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);
}
