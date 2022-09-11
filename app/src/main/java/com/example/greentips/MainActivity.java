package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);

    }

    private void icon_reset(){
        home.setBackgroundColor(Color.parseColor("#BBDEBA"));
        notes.setBackgroundColor(Color.parseColor("#BBDEBA"));
        trash.setBackgroundColor(Color.parseColor("#BBDEBA"));
        dollar.setBackgroundColor(Color.parseColor("#BBDEBA"));
    }
    public void selected(View v){
        icon_reset();
        v.setBackgroundColor(Color.parseColor("#227325"));
    }
}