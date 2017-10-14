package com.kct.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Flashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashscreen);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                synchronized (this){
                    try {
                        wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent Home=new Intent(getApplicationContext(),Home.class);
                    startActivity(Home);
                    finish();

                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();

    }
}
