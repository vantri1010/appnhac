package com.example.nguyenductuan.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nguyenductuan.myapplication.Activity.PlayNhacActivity;
import com.example.nguyenductuan.myapplication.Model.Baihat;
import com.example.nguyenductuan.myapplication.R;
import com.example.nguyenductuan.myapplication.Service.APIService;
import com.example.nguyenductuan.myapplication.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatAdapterForAlbum extends RecyclerView.Adapter<DanhSachBaiHatAdapterForAlbum.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public DanhSachBaiHatAdapterForAlbum(Context context,ArrayList<Baihat> baihatArrayList)
    {
        this.context = context;
        this.mangbaihat = baihatArrayList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachBaiHatAdapterForAlbum.ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtcasi.setText(baihat.getCasi());
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txttenbaihat, txtcasi,txtindex;
        ImageView imghinh, imgluotthich;

        public ViewHolder(View itemView) {
            super(itemView);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            txtcasi  = itemView.findViewById(R.id.textviewtencasi);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            imghinh = itemView.findViewById(R.id.imageviewbaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, PlayNhacActivity.class);
//                    intent.putExtra("cacbaihat", mangbaihat);
//                    context.startActivity(intent);
//                }
//            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotThich("1", mangbaihat.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")) {
                                Toast.makeText(context, "Da thich", Toast.LENGTH_SHORT).show();
                            }
                            else Toast.makeText(context, "Loi!!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(context, t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }

    }
}
