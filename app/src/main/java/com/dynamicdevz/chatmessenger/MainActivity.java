package com.dynamicdevz.chatmessenger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dynamicdevz.chatmessenger.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private EditText textEditText;
private Button sendButton;
private TextView mainTV;
private static final int REQUEST_CODE = 100;
private SharedPreferences sharedPreferences;
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String value = sharedPreferences.getString("KEY", null);
        if(value != null){
            mainTV.setText(value);
        }


    textEditText = findViewById(R.id.type_editview);
    sendButton = findViewById(R.id.send_button);

    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Intents
            //Explicit intent
            Intent getTextIntent = new Intent(MainActivity.this, NextActivity.class);
            getTextIntent.putExtra("text", textEditText.getText().toString().trim());
            startActivityForResult(getTextIntent, REQUEST_CODE);
        }
    });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mainTV = findViewById(R.id.chat_textview);
        if(requestCode == REQUEST_CODE){
            String dataString = data.getStringExtra("from");
            mainTV.setText(dataString);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("KEY", dataString);
            edit.apply();
        }
    }
}