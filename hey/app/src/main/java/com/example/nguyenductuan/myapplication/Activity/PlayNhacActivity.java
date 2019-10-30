package com.example.nguyenductuan.myapplication.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;
import java.util.ArrayList;

/**
 * Created by Nguyen Duc Tuan on 29-Oct-19.
 */

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txtTimesong, txtTotaltimsong;
    SeekBar sktime;
    ImageButton imgplay, imgrepeat, imgnext, imgpre, imgrandom;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Baihat> mangbaihat =new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        init();
        GetDataFromIntent();
    }
    public  void GetDataFromIntent()
    {
        Intent intent = getIntent();
        mangbaihat.clear();
        if(intent != null)
        {

            if (intent.hasExtra("cakhuc")) {
                Baihat baihat = intent.getParcelableExtra("cakhuc");
                Toast.makeText(this, baihat.getTenbaihat(), Toast.LENGTH_SHORT).show();
                mangbaihat.add(baihat);
            }
            if (intent.hasExtra("cacbaihat")) {
                ArrayList<? extends Baihat> baihatArrayList = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = (ArrayList<Baihat>) baihatArrayList;
            }
        }

    }

    private void init() {
        toolbar = findViewById(R.id.toolbarplaynhac);
        txtTimesong = findViewById(R.id.textviewtimesong);
        txtTotaltimsong = findViewById(R.id.textviewtotaltimesong);
        sktime = findViewById(R.id.seekbarsong);
        imgplay = findViewById(R.id.imagebuttonplay);
        imgrepeat = findViewById(R.id.imagebuttonrepeat);
        imgnext = findViewById(R.id.imagebuttonnext);
        imgrandom = findViewById(R.id.imagebuttonsuffle);
        imgpre = findViewById(R.id.imagebuttonreview);
        viewPagerplaynhac = findViewById(R.id.viewpagerplaynhac);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitleTextColor(Color.WHITE);

    }
}



