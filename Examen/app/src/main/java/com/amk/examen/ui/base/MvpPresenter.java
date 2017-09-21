package com.amk.examen.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
