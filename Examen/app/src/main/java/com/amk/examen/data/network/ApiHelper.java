package com.amk.examen.data.network;

import com.amk.examen.data.network.model.GettingStartedResponse;

import io.reactivex.Observable;

/**
 * Created by andresaleman on 9/21/17.
 */

public interface ApiHelper
{
    Observable<GettingStartedResponse> getGettingStartedApiCall();

    Observable<GettingStartedResponse> getGettingStartedArtistsApiCall(String primaryGenreName);
}
