package com.amk.examen.ui.main.artist;

import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface ArtistMvpView extends MvpView
{
    void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList);
}
