package com.example.nguyenductuan.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenductuan.myapplication.Adapter.DanhSachBaiHatAdapter;
import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;
import com.example.nguyenductuan.myapplication.Service.APIService;
import com.example.nguyenductuan.myapplication.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Nguyen Duc Tuan on 29-Oct-19.
 */

public class Fragment_Danh_Sach_Bai_Hat extends android.support.v4.app.Fragment {
    View view;
    RecyclerView recyclerViewbaihat;
    DanhSachBaiHatAdapter baihatAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_danh_sach_bai_hat,container,false);
        recyclerViewbaihat = view.findViewById(R.id.recyclerviewbaihat);
        GetData();
        return view;
    }
    private void GetData()
    {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaiHat();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat>baihatArrayList=(ArrayList<Baihat>) response.body();
                baihatAdapter = new DanhSachBaiHatAdapter(getActivity(),baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager((getActivity()));
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihat.setLayoutManager(linearLayoutManager);
                recyclerViewbaihat.setAdapter(baihatAdapter);

            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }




















}
