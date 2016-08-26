package com.example.user.hintcheatactivity;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import org.w3c.dom.Text;

import java.util.Random;



public class QuizActivity extends AppCompatActivity {


    int pressed = 0;
    int clicked=0;
    private static final String TAG = "QuizActivity";
    public final static String HINT_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public final static String CHEAT_MESSAGE = "com.example.myfirstapp.MESSAGE";
    TextView textview;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // mTrueButton = (Button) findViewById(R.id.TrueButton);
        if (savedInstanceState != null) {
       /*When rotation occurs
         */
            String state = savedInstanceState.getString("myString");

            textview = (TextView) findViewById(R.id.textViewer);
            textview.setText(state);


        } else {
            //When onCreate is called for the first time

            textview = (TextView) findViewById(R.id.textViewer);
            int random = getRandomNumberInRange(1, 1000);
            String s1 = Integer.toString(random);
            String s2 = s1.concat(" is a prime number?");
            textview.setText(s2);


        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    public void changeMessage(View v) {
        //action event for next button
        clicked=0;
        pressed=0;
        TextView textview = (TextView) findViewById(R.id.textViewer);
        int t = 0;
        for (int i = 0; i < 1000; i++) {
            t = getRandomNumberInRange(1, 1000);
        }
        String s1 = Integer.toString(t);
        String s2 = s1.concat(" is a prime number?");
        textview.setText(s2);

    }

    public void Hint(View view) {
        pressed++;
        Intent intent = new Intent(this, DisplayHintActivity.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);
        String hint=" check if its divisible by 1 and itself";
        intent.putExtra(HINT_MESSAGE,hint);
        startActivity(intent);
    }

    public void Cheat(View view) {

        clicked++;

        Intent intent = new Intent(this, DisplayCheatActivity.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);

        TextView hintText = (TextView) findViewById(R.id.textViewer);
        String text = hintText.getText().toString();
        String[] s = text.split(" ");
        String message = s[0];
        int check=Integer.parseInt(message);

        int k, flagp = 0;
        if (check == 1) {
            flagp = 1;
        }
        for (k = 2; k <= check / 2; ++k) {
            // condition for nonprime number
            if (check % k == 0) {
                flagp = 1;
                break;
            }
        }

        if(flagp==0) {

            String ans = message.concat(" it is prime");
            intent.putExtra(CHEAT_MESSAGE, ans);
            startActivity(intent);
        }

        else
        {
            String ans = message.concat(" it is not prime");
            intent.putExtra(CHEAT_MESSAGE, ans);
            startActivity(intent);
        }


    }


    public void Correct(View view) {                                               // action event for true button
        // Do something in response to button

        TextView textview = (TextView) findViewById(R.id.textViewer);
        CharSequence text = textview.getText();
        String temp = text.toString();                                                     //extracting the number from question string
        String[] s = temp.split(" ");
        String n = s[0];
        int prime = Integer.parseInt(n);

        Context context = getApplicationContext();

        int i, flag = 0;
        if (prime == 1) {
            flag = 1;
        }
        for (i = 2; i <= prime / 2; ++i) {
            // condition for nonprime number
            if (prime % i == 0) {
                flag = 1;
                break;
            }
        }

        if(flag==0 && pressed>=1 && clicked>=1)
        {
            Toast.makeText(context, "Correct but you have taken hint and cheated", Toast.LENGTH_SHORT).show();
        }
        else if (flag == 0 && pressed>=1) {

            Toast.makeText(context, "Correct but you have taken hint", Toast.LENGTH_SHORT).show();
        }

        else if(flag==0 && clicked>=1)
        {
            Toast.makeText(context, "Correct but you have cheated", Toast.LENGTH_SHORT).show();
        }
        else if(flag==0)
        {
            Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
        }

        else if(flag==1 && clicked>=1 && pressed>=1)
        {
            Toast.makeText(context, " Not Correct but you have taken hint and cheated", Toast.LENGTH_SHORT).show();
        }

        else if (flag == 1 && pressed>=1) {

            Toast.makeText(context, " Not Correct but you have taken hint", Toast.LENGTH_SHORT).show();
        }

        else if(flag==1 && clicked>=1)
        {
            Toast.makeText(context, " Not Correct but you have cheated", Toast.LENGTH_SHORT).show();
        }


        else if(flag==1)
        {
            Toast.makeText(context, " Not Correct", Toast.LENGTH_SHORT).show();
        }
    }



    public void Incorrect(View view) {                                        //action event  for false button
        // Do something in response to button
        TextView textview = (TextView) findViewById(R.id.textViewer);
        CharSequence s = textview.getText();
        String temp = s.toString();
        String[] text = temp.split(" ");
        String n = text[0];
        int prime = Integer.parseInt(n);

        Context context = getApplicationContext();

        int i, flag = 0;
        if (prime == 1) {
            flag = 1;
        }
        for (i = 2; i <= prime / 2; ++i) {
            // condition for nonprime number
            if (prime % i == 0) {
                flag = 1;
                break;
            }
        }

        if (flag != 0  && clicked>=1 && pressed>=1) {

            Toast.makeText(context, "Correct but you have cheated and taken hint", Toast.LENGTH_SHORT).show();
        }
        else if(flag!=0 && clicked>=1)
        {
            Toast.makeText(context, "Correct but you have cheated", Toast.LENGTH_SHORT).show();
        }

        else if(flag!=0 && pressed>=1)
        {
            Toast.makeText(context, "Correct but you have taken hint", Toast.LENGTH_SHORT).show();
        }
        else if(flag!=0)
        {
            Toast.makeText(context, "Correct", Toast.LENGTH_SHORT).show();
        }
        else if(flag==0 && clicked>=1 && pressed>=1)
        {
            Toast.makeText(context, "Not Correct but you have taken hint and cheated", Toast.LENGTH_SHORT).show();
        }

        else if(flag==0 && pressed>=1) {
            Toast.makeText(context, "Not Correct but you have taken hint", Toast.LENGTH_SHORT).show();
        }
        else if(flag==0 && clicked>=1)
        {
            Toast.makeText(context, "Not Correct but you have cheated", Toast.LENGTH_SHORT).show();
        }

        else if(flag==0)
        {
            Toast.makeText(context, "Not Correct", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putCharSequence("myString",textview.getText());

        Log.i(TAG, "Inside onSaveInstance");
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
