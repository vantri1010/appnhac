package com.example.nguyenductuan.myapplication.Service;

import com.example.nguyenductuan.myapplication.Model.Baihat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nguyen Duc Tuan on 29-Oct-19.
 */

public interface Dataservice {
    @GET ("baihatuathich.php")
    Call<List<Baihat>> GetBaiHatHot();
}
