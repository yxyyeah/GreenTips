package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RecycleConsulting extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;
    AppCompatButton submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_consulting);
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);
        submit_button = (AppCompatButton) findViewById(R.id.todo_button);
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
        else if (v.equals(home)) {
            Intent goHome = new Intent();
            goHome.setClass(this,MainActivity.class);
            startActivity(goHome);
            overridePendingTransition(0,0);
            goHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
    }
    
    public void submit(View v){
        v.setBackgroundColor(Color.parseColor("#808080"));
        Toast.makeText(getApplicationContext(), "Thank you for your submission! ", Toast.LENGTH_SHORT).show();
    }
    
}
