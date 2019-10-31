package com.example.nguyenductuan.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenductuan.myapplication.Activity.PlayNhacActivity;
import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Nguyen Duc Tuan on 30-Oct-19.
 */

public class DanhSachBaiHatAdapter extends RecyclerView.Adapter<DanhSachBaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> baihatArrayList;

    public DanhSachBaiHatAdapter(Context context,ArrayList<Baihat> baihatArrayList)
    {
        this.context=context;
        this.baihatArrayList= baihatArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = baihatArrayList.get(position);
        holder.txtcasi.setText(baihat.getCasi());
        holder.txtten.setText(baihat.getTenbaihat());
        String URL = baihat.getHinhbaihat();
        Picasso.with(context).load(URL).placeholder(R.drawable.varioustic).into(holder.imghinh);
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
            txtten = itemView.findViewById(R.id.textviewtenbaihat);
            txtcasi  = itemView.findViewById(R.id.textviewcasibaihat);
            imghinh = itemView.findViewById(R.id.imagebaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewluotlich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", baihatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }

    }
}
