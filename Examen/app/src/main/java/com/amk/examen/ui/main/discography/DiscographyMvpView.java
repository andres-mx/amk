package com.amk.examen.ui.main.discography;

import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.MvpView;

import java.util.ArrayList;

/**
 * Created by andresaleman on 9/22/17.
 */

public interface DiscographyMvpView extends MvpView
{
    void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList);
}
