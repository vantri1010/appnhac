package com.example.nguyenductuan.myapplication.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenductuan.myapplication.R;


/**
 * Created by Nguyen Duc Tuan on 13-Oct-19.
 */

public class Fragment_Tim_Kiem extends android.support.v4.app.Fragment{
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem,container,false);
        return view;
    }
}
