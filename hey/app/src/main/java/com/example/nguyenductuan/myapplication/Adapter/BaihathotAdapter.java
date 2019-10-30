package com.example.nguyenductuan.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nguyen Duc Tuan on 30-Oct-19.
 */

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder> {
   Context context;
   ArrayList<Baihat> baihatArrayList;

    public BaihathotAdapter(Context context,ArrayList<Baihat> baihatArrayList)
    {
        this.context=context;
        this.baihatArrayList= baihatArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Baihat baihat = baihatArrayList.get(position);
       holder.txtcasi.setText(baihat.getCasi());
       holder.txtten.setText(baihat.getTenbaihat());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
{
  TextView txtten, txtcasi;
  ImageView imghinh, imgluotthich;
    public ViewHolder(View itemView) {
        super(itemView);
        txtten = itemView.findViewById(R.id.textviewtenbaihathot);
        txtcasi  = itemView.findViewById(R.id.textviewcasibaihathot);
        imghinh = itemView.findViewById(R.id.imageviewbaihathot);
        imgluotthich = itemView.findViewById(R.id.imageviewluotlich);
    }
}
}
