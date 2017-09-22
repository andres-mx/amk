package com.amk.examen.ui.main.artist;

import com.amk.examen.ui.base.MvpPresenter;
import com.amk.examen.ui.main.categories.CategoriesMvpView;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface ArtistMvpPresenter  <V extends ArtistMvpView>
        extends MvpPresenter<V> {

    void onViewPrepared(String primaryGenreName);
}
