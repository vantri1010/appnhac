package com.example.nguyenductuan.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.nguyenductuan.myapplication.Model.Video;
import com.example.nguyenductuan.myapplication.R;

public class PlayVideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;

    Video video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DataIntent();

        videoView = (VideoView) findViewById(R.id.videoView);
        if (mediaController == null) {
            mediaController = new MediaController(PlayVideoActivity.this);

            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoView);

            // Sét đặt bộ điều khiển cho VideoView.
            videoView.setMediaController(mediaController);
        }
        String videoUrl = video.getLinkVideo();
        videoView.setVideoPath(videoUrl);

        videoView.requestFocus();

        // Sự kiện khi file video sẵn sàng để chơi.
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {

                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                // Khi màn hình Video thay đổi kích thước
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }

    // Khi bạn xoay điện thoại, phương thức này sẽ được gọi
    // nó lưu trữ lại ví trí file video đang chơi.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }

    // Sau khi điện thoại xoay chiều xong. Phương thức này được gọi,
    // bạn cần tái tạo lại ví trí file nhạc đang chơi.
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("video")){
                video = (Video) intent.getSerializableExtra("video");
                Toast.makeText(this, video.getTenVideo(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
