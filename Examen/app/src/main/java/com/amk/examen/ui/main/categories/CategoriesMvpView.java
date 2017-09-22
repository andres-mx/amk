package com.amk.examen.ui.main.categories;

import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface CategoriesMvpView extends MvpView {

    void updateRepo(ArrayList<GettingStartedResponse.Result> resultArrayList);
}

