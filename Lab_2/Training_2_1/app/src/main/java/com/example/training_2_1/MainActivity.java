package com.example.training_2_1;

import android.animation.*;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imgAnimal;
    LinearLayout BLlayout;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        changeAnimal();
    }
    private void changeAnimal(){
        int[] imgA = {R.drawable.dog, R.drawable.penguin, R.drawable.turtle};
        int[] colorB = {R.color.purple_200, R.color.purple_500,R.color.purple_700, R.color.tear_200,R.color.tear_700};
        imgAnimal = findViewById(R.id.imgAnimal);
        imgAnimal.setImageResource(imgA[new Random().nextInt(imgA.length)]);
        BLlayout = findViewById(R.id.backgroudlayout);
        BLlayout.setBackgroundColor(colorB[new Random().nextInt(colorB.length)]);
    }
    private void animateprogressBar()
    {
        pb = findViewById(R.id.pbl);
        int[] colorP = new int[]{
                ContextCompat.getColor(this, R.color.red),
                ContextCompat.getColor(this, R.color.orange),
                ContextCompat.getColor(this, R.color.yellow),
                ContextCompat.getColor(this, R.color.green),
                ContextCompat.getColor(this, R.color.blue),
                ContextCompat.getColor(this, R.color.indigo),
                ContextCompat.getColor(this, R.color.violet)
        };
        ValueAnimator colorAnimate = ValueAnimator.ofObject(new ArgbEvaluator(),colorP);
        colorAnimate.setDuration(3000);
        colorAnimate.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimate.setRepeatMode(ValueAnimator.RESTART);
        colorAnimate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int c = (int) valueAnimator.getAnimatedValue();
                pb.getProgressDrawable().setColorFilter(c, PorterDuff.Mode.SRC_IN);
            }
        });
        colorAnimate.start();
    }
}