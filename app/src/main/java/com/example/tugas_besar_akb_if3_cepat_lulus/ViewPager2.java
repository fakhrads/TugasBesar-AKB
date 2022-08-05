package com.example.tugas_besar_akb_if3_cepat_lulus;
// nama  : muhammad rojabi nur fauzi
// nim   : 10119091
// kelas : if_3

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewPager2 extends Activity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent pindahIntent = new Intent(ViewPager2.this, ViewPager3.class);
                startActivity(pindahIntent);
                break;
        }
    }
}