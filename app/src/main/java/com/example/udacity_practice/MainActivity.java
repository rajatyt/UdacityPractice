package com.example.udacity_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    Button add,sub,faltu;
    int noOfCoffee=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=findViewById(R.id.addBtn);
        sub=findViewById(R.id.subBtn);
        faltu=findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfCoffee++;
                display(noOfCoffee);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noOfCoffee<=0){
                    Toast.makeText(MainActivity.this, "cannot have negative quantity", Toast.LENGTH_SHORT).show();
                }else {
                    noOfCoffee--;
                    display(noOfCoffee);
                }
            }
        });


    }
    public void submitOrder(View view){
        String displayMsg="Thank you for ordering "+noOfCoffee+" coffee";
        displayCurr(noOfCoffee*5);
        dislayMessage(displayMsg);
    }

    private void dislayMessage(String msg) {
        TextView tv=findViewById(R.id.displayTextView);
        tv.setText(msg);
    }

    private void displayCurr(int i) {
        TextView curr=findViewById(R.id.price);
        curr.setText(NumberFormat.getCurrencyInstance().format(i));
    }

    private void display(int i) {
        TextView tv=findViewById(R.id.quantity);
        tv.setText(""+i);

    }
}