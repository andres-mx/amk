package com.amk.examen.ui.main.discography;

import com.amk.examen.ui.base.MvpPresenter;
import com.amk.examen.ui.main.categories.CategoriesMvpView;

/**
 * Created by andresaleman on 9/22/17.
 */

public interface DiscographyMvpPresenter<V extends DiscographyMvpView>
        extends MvpPresenter<V>
{
    void onViewPrepared(String discography);
}
