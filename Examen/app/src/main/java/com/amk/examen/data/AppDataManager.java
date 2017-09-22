package com.amk.examen.data;

import android.content.Context;

import com.amk.examen.data.db.DbHelper;
import com.amk.examen.data.network.ApiHelper;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.data.prefs.PreferencesHelper;
import com.amk.examen.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by andresaleman on 9/21/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<GettingStartedResponse> getGettingStartedApiCall() {
        return mApiHelper.getGettingStartedApiCall();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPreferencesHelper.getCurrentUserLoggedInMode();
    }

    @Override
    public void setCurrentUserLoggedInMode(LoggedInMode mode) {
        mPreferencesHelper.setCurrentUserLoggedInMode(mode);
    }

    @Override
    public void updateUserInfo(LoggedInMode loggedInMode)
    {
        setCurrentUserLoggedInMode(loggedInMode);
    }

    @Override
    public void setUserAsLoggedOut() {
        updateUserInfo(DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT);
    }
}
