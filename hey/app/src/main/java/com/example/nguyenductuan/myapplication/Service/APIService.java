package com.example.nguyenductuan.myapplication.Service;

/**
 * Created by Nguyen Duc Tuan on 29-Oct-19.
 */

public class APIService {
    private static String base_url="https://appmp3ductuan.000webhostapp.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
