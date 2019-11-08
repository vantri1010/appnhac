package com.example.nguyenductuan.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Nguyen Duc Tuan on 28-Oct-19.
 */

public class PlaynhacAdapter extends RecyclerView.Adapter<PlaynhacAdapter.ViewHolder>{
    Context context;
    ArrayList<Baihat> mangbaihat = new ArrayList<Baihat>();

    public PlaynhacAdapter(FragmentActivity activity, ArrayList<Baihat> mangbaihat) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.dong_play_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Baihat baihat = mangbaihat.get(position);
         holder.txtcasi.setText(baihat.getCasi());
         holder.txtindex.setText(position + 1 +"");
         holder.txttenbaihat.setText(baihat.getTenbaihat());
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       TextView txtindex, txttenbaihat, txtcasi;

       public ViewHolder(View itemView) {
           super(itemView);
           txtcasi= itemView.findViewById(R.id.textviewplaynhactencasi);
           txtindex= itemView.findViewById(R.id.textviewplaynhacindex);
           txttenbaihat= itemView.findViewById(R.id.textviewplaynhactenbaihat);

       }
   }

}
