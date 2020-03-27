package com.example.consciousagainstcorona;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.consciousagainstcorona.R;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class activit extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_act);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_info:
                Intent intent1=new Intent(activit.this,info.class);
                startActivity(intent1);

                break;
            case R.id.nav_activities:
                Intent intent2=new Intent(activit.this,activit.class);
                startActivity(intent2);

                break;
            case R.id.nav_prevention:
                Intent intent3=new Intent(activit.this,prevn.class);
                startActivity(intent3);

                break;
            case R.id.nav_stayhome:
                Intent intent4=new Intent(activit.this,stay.class);
                startActivity(intent4);

                break;
            case R.id.nav_symptoms:
                Intent intent5=new Intent(activit.this,symptoms.class);
                startActivity(intent5);

                break;
            case R.id.nav_home:
                Intent intent6=new Intent(activit.this,MainActivity.class);
                startActivity(intent6);

                break;
            case R.id.nav_stat:
                Intent intent7=new Intent(activit.this,last.class);
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

}