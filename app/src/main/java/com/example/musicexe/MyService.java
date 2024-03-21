package com.example.musicexe;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer myMusic;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // khởi tạo đối tượng mà service quản lý
    @Override
    public void onCreate() {
        super.onCreate();
        myMusic = MediaPlayer.create(MyService.this, R.raw.musichay);
        myMusic.setLooping(true);
    }

    // khởi động đối tượng mà service quản lý
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!myMusic.isPlaying()) {
            myMusic.start();
        } else {
            myMusic.pause();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    // hàm dùng để dừng đối tượng mà service quản lý
    @Override
    public void onDestroy() {
        super.onDestroy();
        myMusic.stop();
    }
}