package com.dynamicdevz.chatmessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    private TextView textTV;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        textTV = findViewById(R.id.chat_textview);
        sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String value = sharedPreferences.getString("KEY", null);

        Intent rI = getIntent();
        if(rI != null){
            String text = rI.getStringExtra("text");


            String fromActivity = text;
            textTV.setText(fromActivity);


            Intent dataIntent = new Intent();
            dataIntent.putExtra("from", fromActivity);
            setResult(RESULT_OK, dataIntent);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("KEY", fromActivity);
            edit.apply();


            new Handler(getMainLooper()).postDelayed(new Runnable(){
                @Override
                public void run() {
                    finish();
                }
            }, 6000);
        }
    }
}