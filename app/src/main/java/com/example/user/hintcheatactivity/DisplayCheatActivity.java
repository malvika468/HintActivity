package com.example.user.hintcheatactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayCheatActivity extends AppCompatActivity {


    int c=0;
    public final static String cheaten_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_cheat);

        //Intent intent = new Intent(this, QuizActivity.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);
        //intent.putExtra(cheaten_MESSAGE,cheattaken);
        //startActivity(intent);


    }

    public void showAnswer(View view)
    {
         c++;

        Intent intent1 = new Intent(this, QuizActivity.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);
        intent1.putExtra(cheaten_MESSAGE,c);
        //startActivity(intent);
        setResult(RESULT_OK, intent1);
        //finish();

        Intent intent = getIntent();
        String message = intent.getStringExtra(QuizActivity.CHEAT_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_cheat);
        layout.addView(textView);


    }

}
