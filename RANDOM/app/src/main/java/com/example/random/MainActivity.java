package com.example.random;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtnDice;
    Button btnDice,btnNum,btnCNum;
    TextView txtRnum;
    EditText txtL,txtR;
    LinearLayout llnum,llcnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
    }
    protected void initControl()
    {
        btnNum = findViewById(R.id.btnRnum);
        btnDice = findViewById(R.id.btnRDice);
        imgbtnDice = findViewById(R.id.imgbtnDice);
        btnCNum = findViewById(R.id.btnRanNum);
        txtRnum = findViewById(R.id.txtNum);
        txtL = findViewById(R.id.txtL);
        txtR = findViewById(R.id.txtR);
        llnum = findViewById(R.id.llnum);
        llcnum = findViewById(R.id.llcnum);
        btnNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRnum.setVisibility(view.VISIBLE);
                llnum.setVisibility(view.VISIBLE);
                llcnum.setVisibility(view.VISIBLE);
                imgbtnDice.setVisibility(view.GONE);
                btnCNum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        Random ran = new Random();
                        int l = Integer.parseInt(txtL.getText().toString());
                        int r = Integer.parseInt(txtR.getText().toString());
                        if(l>r)
                        {
                            l = l + r;
                            r = l - r;
                            l = l - r;
                        }
                        int v = l + ran.nextInt(r-l) ;
                        txtRnum.setText(String.valueOf(v));
                    }
                });
            }
        });
        btnDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtRnum.setVisibility(view.GONE);
                llnum.setVisibility(view.GONE);
                llcnum.setVisibility(view.GONE);
                imgbtnDice.setVisibility(view.VISIBLE);
                imgbtnDice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view1) {
                        Random ran = new Random();
                        int d= 1+ ran.nextInt(5);
                        if(d == 1){
                            imgbtnDice.setImageResource(R.drawable.d1);
                        }
                        else if (d == 2) {
                            imgbtnDice.setImageResource(R.drawable.d2);
                        }
                        else if (d == 3) {
                            imgbtnDice.setImageResource(R.drawable.d3);
                        }
                        else if (d == 4) {
                            imgbtnDice.setImageResource(R.drawable.d4);
                        }
                        else if (d == 5) {
                            imgbtnDice.setImageResource(R.drawable.d5);
                        }
                        else {
                            imgbtnDice.setImageResource(R.drawable.d6);
                        }
                    }
                });
            }
        });
    }
}

