package com.example.greentips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GarbageSorting extends AppCompatActivity {

    RelativeLayout home,notes,trash,dollar;
    RelativeLayout main_rl_layout;
    boolean display = false;    // whether is displaying the pop up window
    float fontsize = 25;        // pop up font size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_sorting);
        home = (RelativeLayout) findViewById(R.id.layout_homeicon);
        notes = (RelativeLayout) findViewById(R.id.layout_notesicon);
        trash = (RelativeLayout) findViewById(R.id.layout_trash_canicon);
        dollar = (RelativeLayout) findViewById(R.id.layout_dollaricon);
        main_rl_layout = (RelativeLayout) findViewById(R.id.main_rl_layout);
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

    public void organic(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#6cb662"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("Collect food waste and kitchen scraps in a reusable container.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            TextView t_2 = new TextView(getApplicationContext());
            t_2.setText("Once full, empty your reusable container into your green bin (provided by the city). Wash the reusable container and place it back in your kitchen.");
            t_2.setTextColor(Color.WHITE);
            t_2.setTextSize(fontsize);
            TextView t_3 = new TextView(getApplicationContext());
            t_3.setText("Bring your green bin to the street curb on days garbage and recycling are collected.");
            t_3.setTextColor(Color.WHITE);
            t_3.setTextSize(fontsize);

            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(t_2);
            mylayout.addView(t_3);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
    public void glass(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#f0b53e"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("Glass products should never be thrown in the garbage, it is often found in the recycling bin in the form of bottles and containers.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            TextView t_2 = new TextView(getApplicationContext());
            t_2.setText("Glass can be easily recycled and repurposed. When you recycle your " +
                            "glass bottles, they are taken to a plant where they are cleaned, " +
                            "sorted by color, crushed and melted into new glass products. Glass can always be recycled.");
            t_2.setTextColor(Color.WHITE);
            t_2.setTextSize(fontsize);
            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(t_2);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
    public void plastic(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#add2fa"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("The majority of plastic materials are non-biodegradable. After the " +
                    "plastic is recycled, it is purified and melted down. It can be used to " +
                    "create new products, rather than sitting in a landfill and harming the " +
                    "environment. You can recycle any plastics that have the universal recycling symbol on them.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
    public void paper(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#86c2c5"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("Paper is biodegradable and should be separated in your yellow or blue bag.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            TextView t_2 = new TextView(getApplicationContext());
            t_2.setText("Keep paper in a blue recycling bin at home so it is easy to transfer over " +
                    "to a bag on recycling day. Be sure to flatten all cardboard before putting " +
                    "it in the recycling bin. It takes up less space and is far more efficient.");
            t_2.setTextColor(Color.WHITE);
            t_2.setTextSize(fontsize);
            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(t_2);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
    public void metal(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#c13830"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("There are many reasons to start recycling your scrap metal. " +
                    "It’s extremely good for the environment, and it can be a great way to " +
                    "earn a bit of extra money from items that would simply lie around your house otherwise.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            TextView t_2 = new TextView(getApplicationContext());
            t_2.setText("You’ll then need to divide up ferrous (magnetic) and non-ferrous (non-magnetic) metals.");
            t_2.setTextColor(Color.WHITE);
            t_2.setTextSize(fontsize);
            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(t_2);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
    public void battery(View v) {
        if (!display) {
            LinearLayout mylayout = new LinearLayout(getApplicationContext());
            mylayout.setBackgroundColor(Color.parseColor("#703c31"));
            mylayout.setPadding(80, 80, 80, 80);
            mylayout.setGravity(Gravity.CENTER);
            mylayout.setOrientation(LinearLayout.VERTICAL);
            TextView t_1 = new TextView(getApplicationContext());
            t_1.setText("Place your single-use batteries in a zipper-style plastic bag (see through) beside your recycling box.");
            t_1.setTextColor(Color.WHITE);
            t_1.setTextSize(fontsize);
            TextView t_2 = new TextView(getApplicationContext());
            t_2.setText("9V batteries should be taped to prevent accidental discharge. Batteries " +
                    "exceeding a standard D-Cell battery in size are not acceptable in the program.");
            t_2.setTextColor(Color.WHITE);
            t_2.setTextSize(fontsize);
            TextView t_3 = new TextView(getApplicationContext());
            t_3.setText("Please do not place the battery bags inside your blue or grey box.");
            t_3.setTextColor(Color.WHITE);
            t_3.setTextSize(fontsize);
            AppCompatButton b = new AppCompatButton(getApplicationContext());
            b.setBackgroundColor(Color.parseColor("#f2e794"));
            b.setText("Close");
            b.setTextSize(fontsize);
            b.setGravity(Gravity.CENTER);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mylayout.setVisibility(View.INVISIBLE);
                    display = false;
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);


            mylayout.addView(t_1);
            mylayout.addView(t_2);
            mylayout.addView(t_3);
            mylayout.addView(b);
            main_rl_layout.addView(mylayout, params);

            display = true;
        }
    }
}
