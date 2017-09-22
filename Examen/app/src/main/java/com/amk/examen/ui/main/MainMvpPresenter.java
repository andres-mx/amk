package com.amk.examen.ui.main;

import com.amk.examen.di.PerActivity;
import com.amk.examen.ui.base.MvpPresenter;

/**
 * Created by andresaleman on 9/21/17.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onDrawerOptionMainClick();

    void onDrawerOptionLogoutClick();

    void onViewInitialized();

    void onNavMenuCreated();
}