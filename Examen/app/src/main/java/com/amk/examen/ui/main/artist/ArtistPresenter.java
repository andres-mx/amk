package com.amk.examen.ui.main.artist;

import android.support.constraint.solver.Goal;

import com.amk.examen.data.DataManager;
import com.amk.examen.data.network.ApiEndPoint;
import com.amk.examen.data.network.model.GettingStartedResponse;
import com.amk.examen.ui.base.BasePresenter;
import com.amk.examen.utils.FunctionJson;
import com.amk.examen.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by andresaleman on 9/21/17.
 */

public class ArtistPresenter <V extends ArtistMvpView> extends BasePresenter<V>
        implements ArtistMvpPresenter<V>
{
    String response, params;
    FunctionJson functionJson;
    Gson gson;
    GettingStartedResponse gettingStartedResponse;
    @Inject
    public ArtistPresenter(DataManager dataManager,
                               SchedulerProvider schedulerProvider,
                               CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String primaryGenreName)
    {
        getMvpView().showLoading();
        response = "";
        functionJson = new FunctionJson();
        gson = new GsonBuilder().create();
        params="";

        response = functionJson.RequestHttp(ApiEndPoint.ENDPOINT_ARTIST+primaryGenreName,FunctionJson.GET, params);
        gettingStartedResponse = new GettingStartedResponse();
        Type listType = new TypeToken<ArrayList<GettingStartedResponse>>(){}.getType();
        gettingStartedResponse = new GettingStartedResponse();
        gettingStartedResponse = new Gson().fromJson(response.toString(), GettingStartedResponse.class);
        getMvpView().updateRepo(gettingStartedResponse.getResults());
        getMvpView().hideLoading();
    }
}
