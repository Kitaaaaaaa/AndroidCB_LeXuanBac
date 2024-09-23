package com.example.convertcf;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btCF,btFC,btClr;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
    }
    private void initControl(){
        btCF = findViewById(R.id.btCF);
        btFC = findViewById(R.id.btFC);
        et1 = findViewById(R.id.tb1);
        et2 = findViewById(R.id.tb2);
        btClr = findViewById(R.id.btClear);
        btCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et1.getText().toString().isEmpty())
                {
                    Double cf = Double.parseDouble(et1.getText().toString());
                    et2.setText(Double.toString(cf*9/5+32));
                }
            }
        });
        btFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et2.getText().toString().isEmpty())
                {
                    Double fc = Double.parseDouble(et2.getText().toString());
                    et1.setText(Double.toString((fc-32)*5/9));
                }
            }
        });
        btClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                et2.setText("");
            }
        });
    }
}