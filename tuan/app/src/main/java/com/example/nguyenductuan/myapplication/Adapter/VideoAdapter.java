package com.example.nguyenductuan.myapplication.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.example.nguyenductuan.myapplication.Model.Video;
import com.example.nguyenductuan.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class VideoAdapter extends PagerAdapter {
    Context context;
    ArrayList<Video> videoArrayList;

    public VideoAdapter(Context context, ArrayList<Video> videoArrayList) {
        this.context = context;
        this.videoArrayList = videoArrayList;
    }

    @Override
    public int getCount() {
        return videoArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_video,null);

        ImageView imgbackgroundvideo = view.findViewById(R.id.imageviewbackgroudvideo);
        ImageView imgvideo = view.findViewById(R.id.imageviewvideo);
        TextView txttitlevideo = view.findViewById(R.id.textviewtittlevideo);
        TextView txtnoidungvideo = view.findViewById(R.id.textviewnoidungvideo);

        Picasso.with(context).load(videoArrayList.get(position).getHinhVideo()).into(imgbackgroundvideo);
        Picasso.with(context).load(videoArrayList.get(position).getHinhVideo()).into(imgvideo);
        txttitlevideo.setText(videoArrayList.get(position).getTenVideo());
        txtnoidungvideo.setText(videoArrayList.get(position).getCasiVideo());
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
