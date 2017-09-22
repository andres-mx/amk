package com.amk.examen.data;

import com.amk.examen.data.db.DbHelper;
import com.amk.examen.data.network.ApiHelper;
import com.amk.examen.data.prefs.PreferencesHelper;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper
{

    void updateUserInfo(LoggedInMode loggedInMode);

    void setUserAsLoggedOut();

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}

