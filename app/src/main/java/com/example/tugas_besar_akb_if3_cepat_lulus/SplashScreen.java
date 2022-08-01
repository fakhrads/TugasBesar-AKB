package com.example.tugas_besar_akb_if3_cepat_lulus;

//nama  : muhammad rojabi nur fauzi
//nim   : 10119091
//kelas : if-3

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreen.this, ViewPager1.class));
                }
            }
        };
        thread.start();
    }
}