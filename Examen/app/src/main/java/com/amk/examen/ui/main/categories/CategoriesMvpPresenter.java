package com.amk.examen.ui.main.categories;

import com.amk.examen.ui.base.MvpPresenter;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface CategoriesMvpPresenter  <V extends CategoriesMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}