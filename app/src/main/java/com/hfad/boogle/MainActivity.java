package com.hfad.boogle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    Bit bit ;
    Button button ;
    TextView textView;
    EditText editText;
    Random rand = new Random();
    int seconds = 30;
    int minutes = 0;
    //int[][] temp = new int[4][4];
    int [] allNumbers = new int[64];
    int x =0;
    int y =0;
    int ans = 0;
    NumberGiver ndg = new NumberGiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView3);
        gv=(GridView) findViewById(R.id.gridview);
        button =(Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editext);
        allNumbers = ndg.getAllNumbers();
        gv.setAdapter(new CustomAdapter(this, allNumbers));


    }

    public void SelectMatrix(View view) {
        x = (rand.nextInt((5 - 1) + 1) + 1);
        y = (rand.nextInt((5 - 1) + 1) + 1);
        for(int i=x ;i <=x+2; i++) {
        for (int j = y; j <=y + 2; j++) {
            View tv = (View) gv.getChildAt((8 * i )+  j);
            tv.setBackgroundColor(Color.RED);
        }
    }




        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        TextView tv = (TextView) findViewById(R.id.timer);
                        tv.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
                        seconds -= 1;

                        if(seconds == 0)
                        {
                            tv.setText(String.valueOf(minutes)+":"+String.valueOf(seconds));
                            textView.setText("OOPs!! Time Over, You can still try");
                            seconds=60;
                            minutes=minutes-1;

                        }



                    }

                });
            }

        }, 0, 1000);


    }

    public void ButtonPress(View view)
    {
      //int[][] xyz = new int[8][8];
        //xyz =ndg.getAllNumbersin2D();
        int[][] int2DArray = new int[8][8];
        //int[] randomNumbers = new int[64];
        //randomNumbers = ndg.getAllNumbers();
        int k=0;
        for(int i = 0; i< 8; i++)
        {
            for(int j =0; j < 8; j++)
            {
                int2DArray[i][j]= allNumbers[k];
                //    x.append(String.valueOf(int2DArray[i][j]));
                k++;
            }
        }
        bit = new Bit(int2DArray);
        ans = bit.sumRegion(x, y, x+2 ,y+2);
        int enteredNumber =Integer.parseInt(editText.getText().toString());

        if (ans == enteredNumber)
            textView.setText("Yo!! You Won");
        else
            textView.setText("OOPs!! You Lost");

    }

    public void Restart(View view)
    {
        this.recreate();
    }

}


