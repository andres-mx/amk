package com.amk.examen.ui.login;

import com.amk.examen.di.PerActivity;
import com.amk.examen.ui.base.MvpPresenter;

/**
 * Created by andresaleman on 9/21/17.
 */

@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onLoginClick(String user, String password);
}