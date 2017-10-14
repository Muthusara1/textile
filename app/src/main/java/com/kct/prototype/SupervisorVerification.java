package com.kct.prototype;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SupervisorVerification extends AppCompatActivity {
TextView sid,spass;
    Snackbar snackbar;
    Button login;
    SharedPreferences myshared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_verification);
        myshared=getSharedPreferences("users", Activity.MODE_PRIVATE);
        sid=(TextView)findViewById(R.id.sidvalue);
        spass=(TextView)findViewById(R.id.spassvalue);

    }

    public void check(View v){

        int count=myshared.getInt("susers",-1);
        String id,pass;
        int checking=0;
        id=sid.getText().toString();
        pass=spass.getText().toString();

        if(count==-1){

        }else {

            for(int i=1;i<=count;i++){
                if(myshared.getString("sid"+i,null).equals(id) && myshared.getString("spass"+i,null).equals(pass)){
                   checking=1;
                    String userid=myshared.getString("sid"+i,null);
                    SharedPreferences.Editor editor= myshared.edit();
                    editor.putString("suserid",userid);
                    editor.commit();
                }
            }
        }
        if(checking==0){
            RelativeLayout layout=(RelativeLayout)findViewById(R.id.sverify);
            snackbar=Snackbar.make(layout,"Enter Valid Information...!!",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else{

            Intent Supervisor=new Intent(getApplicationContext(),SuperVisorHome.class);
            startActivity(Supervisor);
            Home.activity.finish();
        }

    }
}
