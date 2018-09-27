package com.example.ndbao.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnTao, btnDong;
    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
        notificationHelper = new NotificationHelper(this);
    }

    private void addControls() {
        btnTao = findViewById(R.id.btnTao);
        btnDong = findViewById(R.id.btnDong);
    }

    private void addEvents() {
        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder nb = notificationHelper.getChannel1Notification("có thông báo", "nhấn vào để cập nhật");
                notificationHelper.getManager().notify(1, nb.build());
            }
        });
    }
}
