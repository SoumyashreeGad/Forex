package com.example.soumyashree.forex;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import java.util.Calendar;
import java.util.Date;
//import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class SetReminderActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private Date settime;
    private String mailid;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private static Button button_remindsave;
    private static final String[]currency = {"Rupee", "USD", "Euro"};
    private static final String[]time = {"1 Minute","12 hours","1 Day", "1 Week"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);
        Intent i =getIntent();
        mailid = i.getStringExtra("email");

        spinner1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currency);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currency);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner3 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,time);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        onClickbuttonListener();

    }

    public void onClickbuttonListener(){

        button_remindsave = (Button)findViewById(R.id.button4);
        button_remindsave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        settime=new Date();
                        mHandler.postDelayed(new Runnable() {
                            public void run() {
                                sendSMSMessage();
                            }
                        }, 6000);


                    }
                }
        );
    }
    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = mailid.toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("5138287234", null, "Hello! This is reminder from the Forex App to convert your currency since the exchange rate is currently close to the value you have chosen.", null, null);
            Toast.makeText(getApplicationContext(), "Reminder Set.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
