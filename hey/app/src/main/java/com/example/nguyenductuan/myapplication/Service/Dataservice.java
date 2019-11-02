package com.example.nguyenductuan.myapplication.Service;

import android.util.Log;

import com.example.nguyenductuan.myapplication.Model.Baihat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nguyen Duc Tuan on 29-Oct-19.
 */

public interface Dataservice {
    @GET ("baihat.php")
    Call<List<Baihat>> GetBaiHat();

    @FormUrlEncoded
    @POST("timkiembaihat.php")
    Call<List<Baihat>> GetSearchBaiHat(@Field("tukhoa") String tukhoa);
}
