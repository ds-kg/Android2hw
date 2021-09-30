package com.example.android2hw;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView camera;
    private TextView mail, theme, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ititViews();
        initListeners();
    }

    private void ititViews() {
            mail = findViewById(R.id.et_mail);
            theme = findViewById(R.id.et_theme);
            message = findViewById(R.id.et_message);
            camera = findViewById(R.id.camera_btn);
            button = findViewById(R.id.send_btn);
    }


    private void initListeners() {
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND );
                intent.putExtra(Intent.EXTRA_EMAIL , new String[]{"ken.das@bk.ru"});
                intent.putExtra(Intent.EXTRA_SUBJECT , "theme");
                intent.putExtra(Intent.EXTRA_TEXT , "My theme");
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent , "Выберите ваш Аккаунт : "));
            }
        });
    }
}