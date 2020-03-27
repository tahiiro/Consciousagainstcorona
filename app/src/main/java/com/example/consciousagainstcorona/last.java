package com.example.consciousagainstcorona;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class last extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_last);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView=(WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.worldometers.info/coronavirus/?fbclid=IwAR2aciGoni790OSvNYJktX4eo5kU3h-PFUIQr3ePOE8FcLnR1o9IQZ5_Zko");


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
                Intent intent1=new Intent(last.this,info.class);
                startActivity(intent1);

                break;
            case R.id.nav_activities:
                Intent intent2=new Intent(last.this,activit.class);
                startActivity(intent2);

                break;
            case R.id.nav_prevention:
                Intent intent3=new Intent(last.this,prevn.class);
                startActivity(intent3);

                break;
            case R.id.nav_stayhome:
                Intent intent4=new Intent(last.this, last.class);
                startActivity(intent4);

                break;
            case R.id.nav_symptoms:
                Intent intent5=new Intent(last.this,symptoms.class);
                startActivity(intent5);

                break;
            case R.id.nav_home:
                Intent intent6=new Intent(last.this,MainActivity.class);
                startActivity(intent6);

                break;
            case R.id.nav_stat:
                Intent intent7=new Intent(last.this,last.class);
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