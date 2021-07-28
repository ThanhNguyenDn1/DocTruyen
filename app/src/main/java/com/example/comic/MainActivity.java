package com.example.comic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private TextView tvDanGian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEvent();
        setEvet();
    }

    private void setEvet() {
        tvDanGian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ViewListComic.class);
                intent.putExtra("category",1);
                startActivity(intent);
            }
        });
    }

    private void addEvent() {
        tvDanGian=(TextView)findViewById(R.id.tv_DanGian);
    }

}