package com.example.caculator2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button plus,sub,mul,dev,gcd,exit;
    EditText numA,numB;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initcontrol();
    }
    private void initcontrol(){
        plus = findViewById(R.id.plus);
        sub = findViewById(R.id.subtract);
        mul = findViewById(R.id.multi);
        dev = findViewById(R.id.devide);
        gcd = findViewById(R.id.gcd);
        exit = findViewById(R.id.exit);
        numA = findViewById(R.id.numA);
        numB = findViewById(R.id.numB);
        result = findViewById(R.id.result);
        boolean check;
        if(numA.getText() == null || numB.getText() == null)
            check = false;
        else check = true;
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check)
                    messBox("Không được để trống A và B!");
                else {
                    int a = Integer.parseInt(numA.getText().toString());
                    int b = Integer.parseInt(numB.getText().toString());
                    int res = a + b;
                    result.setText(String.valueOf(res));
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check)
                    messBox("Không được để trống A và B!");
                else {
                    int a = Integer.parseInt(numA.getText().toString());
                    int b = Integer.parseInt(numB.getText().toString());
                    int res = a - b;
                    result.setText(String.valueOf(res));
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check)
                    messBox("Không được để trống A và B!");
                else {
                    int a = Integer.parseInt(numA.getText().toString());
                    int b = Integer.parseInt(numB.getText().toString());
                    int res = a * b;
                    result.setText(String.valueOf(res));
                }
            }
        });
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check)
                    messBox("Không được để trống A và B!");
                else {
                    int a = Integer.parseInt(numA.getText().toString());
                    int b = Integer.parseInt(numB.getText().toString());
                    if(a == 0)
                        messBox("A phải khác 0!");
                    else {
                        int res = a / b;
                        result.setText(String.valueOf(res));
                    }
                }
            }
        });
        gcd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!check)
                    messBox("Không  được để trống A và B!");
                else {
                    int a = Integer.parseInt(numA.getText().toString());
                    int b = Integer.parseInt(numB.getText().toString());
                    if(a !=0 && b!=0) {
                        while (a != b) {
                            if (a > b) a -= b;
                            else b -= a;
                        }
                    }
                    result.setText(String.valueOf(a));
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void messBox(String mess){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage(mess);
        builder.setPositiveButton("Đã hiểu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}