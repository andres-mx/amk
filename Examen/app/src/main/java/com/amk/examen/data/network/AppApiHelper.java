package com.amk.examen.data.network;

import com.amk.examen.data.network.model.GettingStartedResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by andresaleman on 9/21/17.
 */

@Singleton
public class AppApiHelper implements ApiHelper
{

    @Inject
    public AppApiHelper() {

    }

    @Override
    public Observable<GettingStartedResponse> getGettingStartedApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BASE)
                .build()
                .getObjectObservable(GettingStartedResponse.class);
    }

    @Override
    public Observable<GettingStartedResponse> getGettingStartedArtistsApiCall(String primaryGenreName) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BASE)
                .build()
                .getObjectObservable(GettingStartedResponse.class);
    }
}
