package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GreenReminder extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;
    EditText todo_msg;
    AppCompatButton todo_button;
    LinearLayout scroll_todo;
    List<String> todo_list = new ArrayList<String>();
    List<String> todo_color = new ArrayList<String>();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_reminder);
        preferences = getSharedPreferences("TODO", Context.MODE_PRIVATE);
        editor = preferences.edit();
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);
        todo_msg = (EditText) findViewById(R.id.todo_msg);
        todo_button = (AppCompatButton) findViewById(R.id.todo_button);
        scroll_todo = (LinearLayout) findViewById(R.id.scroll_todo);

        //add colors
        todo_color.add("#fce9f1");
        todo_color.add("#e9fcf4");
        todo_color.add("#feece8");
        todo_color.add("#e8fafe");
        todo_color.add("#ece8fe");

        // retrieve todos from preferences
        Map<String,String> m = (Map<String, String>) preferences.getAll();
        Collection<String> c = m.values();
        todo_list = new ArrayList<String>(c);

        // create todos from string
        for (String msg:todo_list){
            prep_msg(msg);
        }
    }

    public void selected(View v){
        // store todos to preferences
        int n = 1;
        for (String todo : todo_list){
            editor.putString(Integer.toString(n),todo);
            editor.commit();
            n += 1;
        }

        // jump to activity
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
        if (msg.equals("")){
            Toast.makeText(getApplicationContext(),"Enter your todo",Toast.LENGTH_SHORT).show();
        }
        else {
            prep_msg(msg);
            todo_list.add(msg);
            // clear edit text
            todo_msg.setText("");
        }
    }

    // need to add buttons to delete todos
    private void prep_msg(String msg){
        // outer wrapper
        RelativeLayout wrapper_out = new RelativeLayout(getApplicationContext());
        wrapper_out.setPadding(60,40,60,40);

        // inner wrapper
        RelativeLayout wrapper_in = new RelativeLayout(getApplicationContext());
        RelativeLayout.LayoutParams params_in = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        wrapper_in.setLayoutParams(params_in);
        wrapper_in.setPadding(30,30,30,30);
        wrapper_in.setGravity(Gravity.CENTER);

        // text view
        TextView new_msg = new TextView(getApplicationContext());
        new_msg.setText(msg);
        new_msg.setTextSize(20);

        // get random color
        Random rand = new Random();
        String c = todo_color.get(rand.nextInt(todo_color.size()));
        wrapper_in.setBackgroundColor(Color.parseColor(c));

        // add view
        wrapper_in.addView(new_msg);
        wrapper_out.addView(wrapper_in);
        scroll_todo.addView(wrapper_out);
    }
}