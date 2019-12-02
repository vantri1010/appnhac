package com.example.nguyenductuan.myapplication.Service;

import com.example.nguyenductuan.myapplication.Model.Album;
import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.Model.Video;

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

    @GET ("album.php")
    Call<List<Album>> GetAlbum();

    @GET("allalbum.php")
    Call<List<Album>> GetAllalbum();

    @FormUrlEncoded
    @POST("baihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @GET("video.php")
    Call<List<Video>> GetDataVideo();
}
