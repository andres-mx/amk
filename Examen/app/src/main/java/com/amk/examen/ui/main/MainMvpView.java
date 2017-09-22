package com.amk.examen.ui.main;

import com.amk.examen.ui.base.MvpView;

import java.util.List;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface MainMvpView extends MvpView
{
    void openLoginActivity();

    void showMainFragment();

    void showArtistFragment(String primaryGenreName);

    void showDiscographyFragment(String discography);

    void onInteractionKind(String primaryGenreName);

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
