package com.example.kuchtumkaho_kuchhumkahe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textViews, textViewr;
    final int TERI_TO_LAG_GAI = 207;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewr = findViewById(R.id.textViewResult);
        textViews = findViewById(R.id.textViewSpeak);

        textViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Check", Toast.LENGTH_SHORT).show();
                bolhalkehalke();

            }
        });
    }

    private void bolhalkehalke() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);//invoke lang module
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "sasoo ko kuch kahne do!!!");
        startActivityForResult(intent, TERI_TO_LAG_GAI);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TERI_TO_LAG_GAI) {  //support for the local language  string is class
            if (resultCode == RESULT_OK && data != null) {
                ArrayList<String> stringArrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                textViewr.setText(stringArrayList.get(0));
            }
        }
    }
}
