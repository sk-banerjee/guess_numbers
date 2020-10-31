package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int computerSelectedNumber;
    private static final int BOUND = 20;
    private Random random;

    public void onStratOverButtonClick(View v) {
        EditText userNumber = findViewById(R.id.editTextNumber);
        TextView userMsg = findViewById(R.id.textView3);
        userMsg.setText("");
        userNumber.setText("");
        computerSelectedNumber = random.nextInt(BOUND);
    }
    public void onGuessButtonClick(View v) {
        EditText userNumber = findViewById(R.id.editTextNumber);
        TextView userMsg = findViewById(R.id.textView3);
        String guess = userNumber.getText().toString();
        String msg = "";

        if(guess.length() == 0) {
            Toast.makeText(this, "You forgot to enter your guess!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        int number = Integer.parseInt(guess);

        Log.i("app", computerSelectedNumber + " is selected number.");
        if(number < 0 || number > BOUND) {
            msg = "Your guess is outside the range 0 - 20.";
        } else {
            if (number < computerSelectedNumber) {
                msg = number + " is lower.";
                Log.i("app", msg);
                userMsg.setText(msg);
            } else if (number > computerSelectedNumber) {
                msg = number + " is higher.";
                Log.i("app", msg);
                userMsg.setText(msg);
            } else if (number == computerSelectedNumber) {
                msg = "Your guess is right.";
                Log.i("app", "Your guess is right.");
            }
        }
        userMsg.setText(msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        random = new Random();
        computerSelectedNumber = random.nextInt(BOUND);
        setContentView(R.layout.activity_main);
    }
}