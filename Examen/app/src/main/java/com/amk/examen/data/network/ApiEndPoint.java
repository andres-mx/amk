package com.amk.examen.data.network;

import com.amk.examen.BuildConfig;

/**
 * Created by andresaleman on 9/21/17.
 */

public final class ApiEndPoint
{
    public static final String ENDPOINT_BASE = BuildConfig.BASE_URL
            + "search?term=rock";

    public static final String ENDPOINT_ARTIST = BuildConfig.BASE_URL
            + "search?term=";

    private ApiEndPoint() {

    }

}
