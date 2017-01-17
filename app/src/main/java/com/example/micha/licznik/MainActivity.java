package com.example.micha.licznik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button button1d;
    Button button2d;
    Button button3d;
    Button button4d;
    Button button1i;
    Button button2i;
    Button button3i;
    Button button4i;
    Button buttonStart;
    Button buttonStop;
    Button buttonPause;

    Handler h=new Handler();
Stoper stoper;
    boolean measurmentPossible=true;
    boolean changePossible=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int n1 = Integer.parseInt(((TextView) findViewById(R.id.textView2)).getText().toString());
                int n2 = Integer.parseInt(((TextView) findViewById(R.id.textView3)).getText().toString());
                int n3 = Integer.parseInt(((TextView) findViewById(R.id.textView4)).getText().toString());
                int n4 = Integer.parseInt(((TextView) findViewById(R.id.textView5)).getText().toString());
                stoper=new Stoper(n1,n2,n3,n4);
               measurmentPossible=false;
                changePossible=false;

            }
        });
        buttonStop= (Button) findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                ((TextView) findViewById(R.id.textView2)).setText("0");
                ((TextView) findViewById(R.id.textView3)).setText("0");
                ((TextView) findViewById(R.id.textView4)).setText("0");
                ((TextView) findViewById(R.id.textView5)).setText("0");
                measurmentPossible=true;
                changePossible=true;

            }
        });
        buttonPause= (Button) findViewById(R.id.buttonPause);
        buttonPause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
              measurmentPossible=true;

            }
        });
        h.post(new Runnable(){

            @Override
            public void run() {
                // call your function
                if(!measurmentPossible)
                {
                    String time=stoper.getTime();
                    if(time.equals("0000"))
                    {
                        measurmentPossible=true;
                        changePossible=true;
                    }
                    ((TextView)findViewById(R.id.textView2)).setText(""+time.charAt(0));
                    ((TextView)findViewById(R.id.textView3)).setText(""+time.charAt(1));
                    ((TextView)findViewById(R.id.textView4)).setText(""+time.charAt(2));
                    ((TextView)findViewById(R.id.textView5)).setText(""+time.charAt(3));
                }
                h.postDelayed(this,1000);

            }

        });

        button1d = (Button) findViewById(R.id.button1d);
        button1d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView2)).getText().toString());
                ((TextView) findViewById(R.id.textView2)).setText("" + changeDigit(digit, 9, -1));
            }
        });

        button2d = (Button) findViewById(R.id.button2d);
        button2d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView3)).getText().toString());
                ((TextView) findViewById(R.id.textView3)).setText("" + changeDigit(digit, 9, -1));
            }
        });

        button3d = (Button) findViewById(R.id.button3d);
        button3d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView4)).getText().toString());
                ((TextView) findViewById(R.id.textView4)).setText("" + changeDigit(digit, 5, -1));
            }
        });

        button4d = (Button) findViewById(R.id.button4d);
        button4d.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView5)).getText().toString());
                ((TextView) findViewById(R.id.textView5)).setText("" + changeDigit(digit, 9, -1));
            }
        });

        button1i = (Button) findViewById(R.id.button1i);
        button1i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView2)).getText().toString());
                ((TextView) findViewById(R.id.textView2)).setText("" + changeDigit(digit, 9, 1));
            }
        });

        button2i = (Button) findViewById(R.id.button2i);
        button2i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView3)).getText().toString());
                ((TextView) findViewById(R.id.textView3)).setText("" + changeDigit(digit, 9, 1));
            }
        });

        button3i = (Button) findViewById(R.id.button3i);
        button3i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView4)).getText().toString());
                ((TextView) findViewById(R.id.textView4)).setText("" + changeDigit(digit, 5, 1));
            }
        });

        button4i = (Button) findViewById(R.id.button4i);
        button4i.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View vw) {
                int digit = Integer.parseInt(((TextView) findViewById(R.id.textView5)).getText().toString());
                ((TextView) findViewById(R.id.textView5)).setText("" + changeDigit(digit, 9, 1));
            }
        });


    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        measurmentPossible = savedInstanceState.getBoolean("measurmentPossible");
        changePossible = savedInstanceState.getBoolean("measurmentPossible");
        ((TextView) findViewById(R.id.textView2)).setText(savedInstanceState.getString("textView2"));
        ((TextView) findViewById(R.id.textView3)).setText(savedInstanceState.getString("textView3"));
        ((TextView) findViewById(R.id.textView4)).setText(savedInstanceState.getString("textView4"));
        ((TextView) findViewById(R.id.textView5)).setText(savedInstanceState.getString("textView5"));
        int n1 = Integer.parseInt(((TextView) findViewById(R.id.textView2)).getText().toString());
        int n2 = Integer.parseInt(((TextView) findViewById(R.id.textView3)).getText().toString());
        int n3 = Integer.parseInt(((TextView) findViewById(R.id.textView4)).getText().toString());
        int n4 = Integer.parseInt(((TextView) findViewById(R.id.textView5)).getText().toString());
        stoper=new Stoper(n1,n2,n3,n4);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("measurmentPossible",measurmentPossible);
        outState.putBoolean("changePossible",changePossible);
        outState.putString("textView2",((TextView) findViewById(R.id.textView2)).getText().toString());
        outState.putString("textView3",((TextView) findViewById(R.id.textView3)).getText().toString());
        outState.putString("textView4",((TextView) findViewById(R.id.textView4)).getText().toString());

        outState.putString("textView5",((TextView) findViewById(R.id.textView5)).getText().toString());

    }
    private int changeDigit(int digit,int max,int step)
    {
        if(!changePossible)
            return digit;
        if(digit+step>max)
            return digit;
        if(digit+step<0)
            return 0;
        return digit+step;
    }
}
