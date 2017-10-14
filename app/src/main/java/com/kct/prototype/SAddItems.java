package com.kct.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Time;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SAddItems extends AppCompatActivity {

    EditText empid,quality1,quality2,quality3,quality4,price1,price2,price3,price4;
    TextView count,price,entryno,date,time;

    String eid,q1,q2,q3,q4;
    int p1=10,p2=15,p3=20,p4;
    String totcount,totprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadd_items);
        empid=(EditText)findViewById(R.id.empid);
        quality1=(EditText)findViewById(R.id.count1);
        quality2=(EditText)findViewById(R.id.count2);
        quality3=(EditText)findViewById(R.id.count3);
        quality4=(EditText)findViewById(R.id.count4);
        price1=(EditText)findViewById(R.id.price1);
        price2=(EditText)findViewById(R.id.price2);
        price3=(EditText)findViewById(R.id.price3);
        price4=(EditText)findViewById(R.id.price4);
        count=(TextView)findViewById(R.id.counttotlabel);
        price=(TextView)findViewById(R.id.pricetotlabel);
        entryno=(TextView)findViewById(R.id.entryno);
        date=(TextView)findViewById(R.id.date);
        time=(TextView)findViewById(R.id.time);

        TextWatcher watcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int qp1,qp2,qp3,qp4;
                int c=0;
                if(quality1.getText().toString().matches("")){
                    qp1=0;
                    price1.setText("0");
                }else{
                    qp1=Integer.parseInt(quality1.getText().toString())*10;
                    c+=Integer.parseInt(quality1.getText().toString());
                    price1.setText(qp1+"");
                }
                if(quality2.getText().toString().matches("")){
                    qp2=0;
                    price2.setText("0");
                }else{
                    qp2=Integer.parseInt(quality2.getText().toString())*15;
                    c+=Integer.parseInt(quality2.getText().toString());
                    price2.setText(qp2+"");
                }
                if(quality3.getText().toString().matches("")){
                    qp3=0;
                    price3.setText("0");
                }else{
                    qp3=Integer.parseInt(quality3.getText().toString())*20;
                    c+=Integer.parseInt(quality3.getText().toString());
                    price3.setText(qp3+"");
                }
                if(quality4.getText().toString().matches("")){
                    qp4=0;
                    price4.setText("0");
                }else{
                    qp4=Integer.parseInt(quality4.getText().toString())*30;
                    c+=Integer.parseInt(quality4.getText().toString());
                    price4.setText(qp4+"");
                }

                price.setText(qp1+qp2+qp3+qp4+"");
                count.setText(c+"");

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    quality1.addTextChangedListener(watcher);
        quality2.addTextChangedListener(watcher);
        quality3.addTextChangedListener(watcher);
        quality4.addTextChangedListener(watcher);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Time time1=new Time();
        time1.setToNow();
        String CurrentDate=time1.format("%d/%m/%y");
        String CurrentTime=time1.format("%H:%M");
        int hour=(Integer.parseInt(CurrentTime.substring(0,2)));

        if(hour>=12){
            CurrentTime=hour+CurrentTime.substring(2)+"PM";
        }else{
            CurrentTime=CurrentTime+"AM";
        }
        date.setText(CurrentDate);
        time.setText(CurrentTime);

        String financialyr=time1.format("%y")+(Integer.parseInt(time1.format("%y"))+1)+"/";
        entryno.setText(financialyr);

    }
}
