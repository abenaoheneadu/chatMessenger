package com.dynamicdevz.chatmessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    private TextView textTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        textTV = findViewById(R.id.chat_textview);

        Intent rI = getIntent();
        if(rI != null){
            String text = rI.getStringExtra("text");


            String fromActivity = text;
            textTV.setText(fromActivity);

            Intent dataIntent = new Intent();
            dataIntent.putExtra("from", fromActivity);
            setResult(RESULT_OK, dataIntent);

            new Handler(getMainLooper()).postDelayed(new Runnable(){
                @Override
                public void run() {
                    finish();
                }
            }, 3000);
        }
    }
}