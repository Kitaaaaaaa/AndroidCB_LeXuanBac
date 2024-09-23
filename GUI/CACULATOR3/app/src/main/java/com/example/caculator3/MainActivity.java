package com.example.caculator3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView tvresult,tvexpression;
    boolean checkNumber = false;
    boolean checkDot = false;
    int countbracket = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvexpression = findViewById(R.id.expression);
        tvresult = findViewById(R.id.result);
    }
    public void onDigit(View v)
    {
        tvexpression.append(((TextView) v).getText());
        checkNumber = true;
    }
    public void onSymbol(View v){
        if(checkNumber){
            tvexpression.append(((TextView) v).getText());
            checkNumber = false;
            checkDot = false;
        }
    }
    public void onDot(View v){
        if(!checkDot && checkNumber){
            tvexpression.append(".");
            checkDot = true;
            checkNumber = false;
        }
    }
    public void onOBracket(View v){
        if(!checkNumber){
            tvexpression.append("(");
            countbracket += 1;
        }
    }
    public void onCBracket(View v){
        if(checkNumber){
            tvexpression.append(")");
            countbracket -= 1;
        }
    }
    @SuppressLint("SetTextI18n")
    public void onResult(View v){
        if(tvexpression.getText().length() == 0){
            tvresult.setText("No result");
        }
        else if(countbracket != 0 || !checkNumber)
        {
            tvresult.setText("Math Error");
        }
        else{
            String express = tvexpression.getText().toString();
            Expression expression = new ExpressionBuilder(express).build();
            double result = expression.evaluate();
            tvresult.setText(Double.toString(result));
        }
    }
    public void onClearAll(View v){
        tvexpression.setText("");
        tvresult.setText("");
        checkNumber = false;
        countbracket = 0;
        checkDot = false;
    }
    public void onDelete(View v){
        if(tvexpression.getText().length() > 0)
        {
            tvexpression.setText(tvexpression.getText().subSequence(0,tvexpression.getText().length()-1));
        }
    }
}