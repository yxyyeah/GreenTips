package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class GreenReminder extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;
    EditText todo_msg;
    AppCompatButton todo_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_reminder);
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);
        todo_msg = (EditText) findViewById(R.id.todo_msg);
        todo_button = (AppCompatButton) findViewById(R.id.todo_button);
    }

    public void selected(View v){
        if (v.equals(home)) {
            Intent goHome = new Intent();
            goHome.setClass(this,MainActivity.class);
            startActivity(goHome);
            overridePendingTransition(0,0);
            goHome.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
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

    public void showMsg(View v){
        String msg = todo_msg.getText().toString();
        if (msg == ""){
            Toast.makeText(getApplicationContext(),"Enter your todo",Toast.LENGTH_SHORT).show();
        }
        else {

        }

    }
}