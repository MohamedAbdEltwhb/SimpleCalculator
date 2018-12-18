package com.example.mm.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView screen;

    private float numberbefor;

    private String opration;

    private ButtonClickListeaner btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        screen = (TextView) findViewById(R.id.result);
        screen.setEnabled(false);
        btn=new ButtonClickListeaner();
        int idslist[] = {R.id.clear , R.id.sub , R.id.add , R.id.dev , R.id.mul , R.id.show ,
                R.id.one, R.id.two, R.id.three, R.id.four , R.id.five , R.id.six ,
                R.id.seven , R.id.eight , R.id.nine ,R.id.zero  };

        for(int id:idslist) {
            View v=findViewById(id);
            v.setOnClickListener(btn);
        }
    }
    public void math(String str) {
        numberbefor = Float.parseFloat(screen.getText().toString());
        opration = str;
        screen.setText("0");
    }

    public void keybord(String str) {
        String current = screen.getText().toString();
        if(current.equals("0"))
            current = "";
        current += str;
        screen.setText(current);
    }
    private void result() {
        float numberafter=Float.parseFloat(screen.getText().toString());
        float result = 0;
        if(opration.equals("+")) {
            result = numberbefor + numberafter;
        }
        if(opration.equals("-")) {
            result = numberbefor - numberafter;
        }
        if(opration.equals("*")) {
            result = numberbefor * numberafter;
        }
        if(opration.equals("/")) {
            result = numberbefor / numberafter;
        }
        screen.setText(String.valueOf(result));


    }

    private class ButtonClickListeaner implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.clear:
                    screen.setText("0");
                    opration = "";
                    break;
                case R.id.add:
                    math("+");
                    break;
                case R.id.sub:
                    math("-");
                    break;
                case R.id.dev:
                    math("/");
                    break;
                case R.id.mul:
                    math("*");
                    break;
                case R.id.show:
                    result();
                    break;
                default:
                    String number = ((Button)v).getText().toString();
                    keybord(number);
                    break;
            }
        }
    }
}
