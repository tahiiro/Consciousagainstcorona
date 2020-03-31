package com.example.consciousagainstcorona;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class stay extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    private Button bstart;
    private Button brestart;
    private TextView tstview;
    private String text;
    private boolean enab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_stayhom);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bstart=(Button)findViewById(R.id.bstart);
        brestart=(Button)findViewById(R.id.brestart);
        tstview=(TextView)findViewById(R.id.txtview);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        brestart.setEnabled(false);
        bstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bstart.setEnabled(false);
                brestart.setEnabled(true);
                tstview.setText("1/15");
                sav_date();

            }
        });
        brestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bstart.setEnabled(true);
                brestart.setEnabled(false);
                tstview.setText("0/15");
                sav_dateres();


            }
        });

            load_data();
            upload();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_info:
                Intent intent1=new Intent(stay.this,info.class);
                startActivity(intent1);

                break;
            case R.id.nav_activities:
                Intent intent2=new Intent(stay.this,activit.class);
                startActivity(intent2);

                break;
            case R.id.nav_prevention:
                Intent intent3=new Intent(stay.this,prevn.class);
                startActivity(intent3);

                break;
            case R.id.nav_stayhome:
                Intent intent4=new Intent(stay.this,stay.class);
                startActivity(intent4);

                break;
            case R.id.nav_symptoms:
                Intent intent5=new Intent(stay.this,symptoms.class);
                startActivity(intent5);

                break;
            case R.id.nav_home:
                Intent intent6=new Intent(stay.this,MainActivity.class);
                startActivity(intent6);

                break;
            case R.id.nav_stat:
                Intent intent7=new Intent(stay.this,last.class);
                startActivity(intent7);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    public void sav_date(){
        SharedPreferences shar=getSharedPreferences("sharbtn",MODE_PRIVATE);
        SharedPreferences.Editor editor=shar.edit();

        SimpleDateFormat tst1=new SimpleDateFormat("dd MM YYYY");
        editor.putString("date",tst1.format(new Date()));
        editor.putBoolean("button",bstart.isEnabled());
        editor.apply();


        Toast.makeText(this,"Start counte",Toast.LENGTH_LONG);
    }
    public void load_data(){
        SharedPreferences shar=getSharedPreferences("sharbtn",MODE_PRIVATE);
        SharedPreferences.Editor editor=shar.edit();
        text=shar.getString("date","");
        enab=shar.getBoolean("button",true);

    }
    public void upload() {

        bstart.setEnabled(enab);
        brestart.setEnabled(!(enab));

        if (enab==false){

        SimpleDateFormat format1 = new SimpleDateFormat("dd MM yyyy");
            String day1=format1.format(new Date());
            String day2=text;
        try {
            Date date1 = format1.parse(day1);
            Date date2 = format1.parse(day2);

            long dif=date2.getTime()-date1.getTime();
            dif=Math.abs(dif);

            tstview.setText(""+(TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS)+1)+"/15");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else{
            tstview.setText("0/15");
        }
    }
    public void sav_dateres(){
        SharedPreferences shar=getSharedPreferences("sharbtn",MODE_PRIVATE);
        SharedPreferences.Editor editor=shar.edit();
        editor.putBoolean("button",bstart.isEnabled());
        editor.apply();
        Toast.makeText(this,"Stop counte",Toast.LENGTH_LONG);
    }
}