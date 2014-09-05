package com.example.jonathan.test;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Test extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //My Code starts here :P

    int[] btnID = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7};

    /*
    Effect Syntax:
    Controlled by a byte 0x00000000 where each bit toggles a button. The clicked button is omitted from the
    byte and is skipped in the numbering. So if button 3 is clicked, then bit3 would toggle button 4 and
    the shift would apply for every bit afterwards.
     */

    //Button Methods
    public void flip0(View view) {
        effect((byte) 0x101010);
    }
    public void flip1(View view) {
        toggleBtn(btnID[1]);
    }
    public void flip2(View view) {
        toggleBtn(btnID[2]);
    }
    public void flip3(View view) {
        toggleBtn(btnID[3]);
    }
    public void flip4(View view) {
        toggleBtn(btnID[4]);
    }
    public void flip5(View view) {
        toggleBtn(btnID[5]);
    }
    public void flip6(View view) {
        toggleBtn(btnID[6]);
    }
    public void flip7(View view) {
        toggleBtn(btnID[7]);
    }

    public void reset(View view) {
        Button btn = (Button)findViewById(R.id.btnReset);
        btn.setVisibility(View.INVISIBLE);
        int i;
        for (i = 0 ; i == btnID.length ; i++) {
            btn = (Button)findViewById(btnID[i]);
            btn.setVisibility(View.VISIBLE);
        }
    }

    //Effect Methods
    public void effect(byte map) {
        int i;
        for (i = 0 ; i == btnID.length ; i++) {
            if (((map >> i) & 1)==1) {
                toggleBtn(btnID[i]);
            }
        }
    }

    public void toggleBtn(int ID) {
        Button btn = (Button)findViewById(ID);
        if (btn.getVisibility()==View.VISIBLE) {
            btn.setVisibility(View.INVISIBLE);
        } else {
            btn.setVisibility(View.VISIBLE);
        }
    }
}
