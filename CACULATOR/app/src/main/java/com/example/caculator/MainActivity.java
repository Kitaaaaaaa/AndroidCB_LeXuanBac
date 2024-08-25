package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    EditText txtx,txty;
    TextView txtResult;
    Button btnplus,btnsub,btnmul,btndiv,btnmod;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
    }
    protected void initControl()
    {
        txtx = findViewById(R.id.txtx);
        txty = findViewById(R.id.txty);
        txtResult = findViewById(R.id.txtResult);
        btnplus = findViewById(R.id.btnPlus);
        btnsub = findViewById(R.id.btnSubtract);
        btnmul = findViewById(R.id.btnMultiply);
        btndiv = findViewById(R.id.btnDiv);
        btnmod = findViewById(R.id.btnMod);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtx.getText().toString());
                int y = Integer.parseInt(txty.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtx.getText().toString());
                int y = Integer.parseInt(txty.getText().toString());
                int result = x - y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtx.getText().toString());
                int y = Integer.parseInt(txty.getText().toString());
                int result = x * y;
                txtResult.setText(String.valueOf(result));
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtx.getText().toString());
                int y = Integer.parseInt(txty.getText().toString());
                if(y == 0)
                {
                    txtResult.setText("Error");
                }
                else
                {
                    int result = x/y;
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
        btnmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtx.getText().toString());
                int y = Integer.parseInt(txty.getText().toString());
                if(y == 0)
                {
                    txtResult.setText("Error");
                }
                else
                {
                    int result = x%y;
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
    }
}