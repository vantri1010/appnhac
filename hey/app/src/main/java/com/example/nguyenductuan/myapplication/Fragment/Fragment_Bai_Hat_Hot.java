package com.example.nguyenductuan.myapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenductuan.myapplication.Adapter.BaihathotAdapter;
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

public class Fragment_Bai_Hat_Hot extends android.support.v4.app.Fragment {
    View view;
    RecyclerView recyclerViewbaihathot;
    BaihathotAdapter baihathotAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_bai_hat_thich_nhat,container,false);
        recyclerViewbaihathot = view.findViewById(R.id.recyclerviewbaihathot);
        GetData();
        return view;
    }
    private void GetData()
    {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetBaiHatHot();
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat>baihatArrayList=(ArrayList<Baihat>) response.body();
          //      Log.d("BBB",baihatArrayList.get(0).getTenbaihat());
                baihathotAdapter = new BaihathotAdapter(getActivity(),baihatArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager((getActivity()));
             linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
             recyclerViewbaihathot.setLayoutManager(linearLayoutManager);
             recyclerViewbaihathot.setAdapter(baihathotAdapter);

              }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }




















}
