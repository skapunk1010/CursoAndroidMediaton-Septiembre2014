package com.example.practica01_helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView txt = (TextView)this.findViewById(R.id.txt);
        Integer a  = 10;
        Integer b = new Integer(20);
        txt.setText(a.toString());
        txt.append(" "+b.toString());
        txt.setTextSize(30);
        txt.setTextColor(Color.RED);
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
