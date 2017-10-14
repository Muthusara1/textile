package com.kct.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SuperVisorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_visor_home);
    }


    public void sadditems(View v){

        Intent sadd=new Intent(getApplicationContext(),SAddItems.class);
        startActivity(sadd);

    }
    public void sviewitems(View v){



    }

}
