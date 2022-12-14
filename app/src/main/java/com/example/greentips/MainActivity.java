package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    public void selected(View v){
        if (v.equals(notes)) {
            Intent goNotes = new Intent();
            goNotes.setClass(this,GreenReminder.class);
            startActivity(goNotes);
            overridePendingTransition(0,0);
            goNotes.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
        else if (v.equals(trash)) {
            Intent goTrash = new Intent();
            goTrash.setClass(this,GarbageSorting.class);
            startActivity(goTrash);
            overridePendingTransition(0,0);
            goTrash.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
        else if (v.equals(dollar)) {
            Intent goDollar = new Intent();
            goDollar.setClass(this,RecycleConsulting.class);
            startActivity(goDollar);
            overridePendingTransition(0,0);
            goDollar.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
    }
}