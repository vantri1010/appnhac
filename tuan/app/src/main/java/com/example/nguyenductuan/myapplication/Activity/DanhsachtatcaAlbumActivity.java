package com.example.nguyenductuan.myapplication.Activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.nguyenductuan.myapplication.Adapter.AllAlbumAdapter;
import com.example.nguyenductuan.myapplication.Model.Album;
import com.example.nguyenductuan.myapplication.R;
import com.example.nguyenductuan.myapplication.Service.APIService;
import com.example.nguyenductuan.myapplication.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {
     RecyclerView recyclerViewAllalbum;
     Toolbar toolbarAlbum;
     AllAlbumAdapter allAlbumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        init();
        GetData();
    }
    private  void GetData()
    {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback =dataservice.GetAllalbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(DanhsachtatcaAlbumActivity.this,mangalbum);
                recyclerViewAllalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2));
                recyclerViewAllalbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
    @SuppressLint("RestrictedApi")
    public void init()
    {
        recyclerViewAllalbum = findViewById(R.id.recyclerviewAllalbum);
        toolbarAlbum = findViewById(R.id.toolbarAllalbum);
        setSupportActionBar(toolbarAlbum);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Album");
        toolbarAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
