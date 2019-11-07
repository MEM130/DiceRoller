package com.example.cs18mme.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DiceRoller extends AppCompatActivity {
    int count = 0;
    private EditText nEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        nEditText= (EditText) findViewById(R.id.numberEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {

        int num = Integer.parseInt(nEditText.getText().toString());
        nEditText.setText(String.valueOf(num));
        if (num > 1 || num < 6) {
            TextView tv = (TextView) this.findViewById(R.id.numberTextView);
            Random r = new Random();
            int number = r.nextInt(6) + 1;
            tv.setText(Integer.toString(number));

            if (num == number) {
                TextView tv1 = (TextView) this.findViewById(R.id.scoreTextView);
                count++;
                tv1.setText(Integer.toString(count));
                Toast.makeText(DiceRoller.this,"Congratulations",Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void on_dicebreaker_button_click (View view){
        TextView tv = (TextView) this.findViewById(R.id.numberTextView);
        Random r = new Random();
        int number = r.nextInt(6) + 1;
        tv.setText(Integer.toString(number));

        switch (number){
            case 1:
                TextView question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you could go anywhere in the world, where would you go?");
                break;
            case 2:
                question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                break;
            case 3:
                question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you could eat only one food for the rest of your life, what would that be?");
                break;
            case 4:
                question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you won a million dollars, what is the first thing you would buy?");
                break;
            case 5:
                question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you could spaned the day with one fictional character, who would it be?");
                break;

            case 6:
                question = (TextView) this.findViewById(R.id.questionTextView);
                question.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                break;



        }

    }
}
