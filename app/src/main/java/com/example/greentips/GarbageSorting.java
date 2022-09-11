package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class GarbageSorting extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_sorting);
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);
    }

    public void selected(View v){
        if (v.equals(home)) {
            Intent goHome = new Intent();
            goHome.setClass(this,MainActivity.class);
            startActivity(goHome);
            overridePendingTransition(0,0);
            goHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
        else if (v.equals(notes)) {
            Intent goNotes = new Intent();
            goNotes.setClass(this,GreenReminder.class);
            startActivity(goNotes);
            overridePendingTransition(0,0);
            goNotes.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
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