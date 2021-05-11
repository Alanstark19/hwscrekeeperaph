package com.example.hwscrekeeperaph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_brightness;
    private TextView txv_count;
    private int count=0;
    static final String STATE_COUNT = "Score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the TextView by ID
        iv_brightness = (ImageView) findViewById(R.id.ivbrightness);
        txv_count = (TextView) findViewById(R.id.txvcount);
        count = Integer.parseInt(txv_count.getText().toString());

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(STATE_COUNT);

            //Set the score text view
            txv_count.setText(String.valueOf(count));
        }
    }

    public void increment() {
        if(count>0 && count<=3){
            if (count == 1){
                iv_brightness.setImageResource(R.drawable.ic_brightness_2);
            }else if (count == 2){
                iv_brightness.setImageResource(R.drawable.ic_brightness_3);
            }else if (count == 3){
                iv_brightness.setImageResource(R.drawable.ic_brightness_4);
            }
            count++;
        }
        //txv_count.setText(count);


    }

    public void decrement() {
        if(count>=2 && count<5){
            if(count == 4){
                iv_brightness.setImageResource(R.drawable.ic_brightness_3);
            }else if (count == 3){
                iv_brightness.setImageResource(R.drawable.ic_brightness_2);
            }else if (count == 2){
                iv_brightness.setImageResource(R.drawable.ic_brightness_1);
            }
            count--;
        }
    }

    public void score(View view) {
        //Get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID){
            //If it was button increment
            case R.id.btn_increment:
                increment();
                //Increment the score and update the TextView
                //count++;
                txv_count.setText(String.valueOf(count));
                break;
            //If it button was decrement
            case R.id.btn_decrement:
                decrement();
                //Increment the score and update the TextView
                //count--;
                txv_count.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_COUNT, count);
        super.onSaveInstanceState(outState);
    }
}