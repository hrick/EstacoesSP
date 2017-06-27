package com.example.logonrm.estacoessp.api;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtil {

    private APIUtil() {
    }

    public static final String BASE_URL = "http://10.3.1.31:3000";

    public static MetroAPI getCarroAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(MetroAPI.class);
    }
}
