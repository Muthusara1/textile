package com.kct.prototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    SharedPreferences myshared;
    static Context context;
    static Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context=this;
        activity=this;
        myshared=getSharedPreferences("users", Activity.MODE_PRIVATE);
        if(myshared.getInt("susers",-1)==-1){
            SharedPreferences.Editor editor=myshared.edit();
            editor.putInt("susers",1);
            editor.putString("sid1","123");
            editor.putString("spass1","123");
            editor.commit();
        }
    }
    public void sauthentication(View v){

        Intent SuperVisorAuthenticate=new Intent(getApplicationContext(),SupervisorVerification.class);
        startActivity(SuperVisorAuthenticate);
    }
}
