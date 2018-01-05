package com.pepoc.androidnewtechnique.customview.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

import com.pepoc.androidnewtechnique.R;

public class AnimationDemoActivity extends AppCompatActivity implements View.OnClickListener {

    private View btnAnimationTest;
    private ViewPropertyAnimator btnAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        init();
    }

    private void init() {
        btnAnimationTest = findViewById(R.id.btn_animation_test);

        btnAnimationTest.setOnClickListener(this);
        btnAnimate = btnAnimationTest.animate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_animation_test:
                btnAnimate.setDuration(3000).setInterpolator(new CustomInterpolator()).translationYBy(500);
//                btnAnimate.xBy(100);
//                btnAnimate.translationXBy(100);
//                btnAnimate.zBy(100);
//                btnAnimate.translationZBy(100);
//                btnAnimate.rotationBy(30);
//                btnAnimate.scaleX(2);
//                btnAnimate.scaleY(2);
//                btnAnimate.alpha(0.5f);
                break;
        }
    }

    class CustomInterpolator implements Interpolator {

        @Override
        public float getInterpolation(float input) {
            int p0 = 0;
            int p1 = 1;
            int m0 = 4;
            int m1 = 4;

            float t = input;
            float t2 = t*t;
            float t3 = t2*t;
            return (2*t3 - 3*t2 + 1)*p0 + (t3-2*t2+t)*m0 + (-2*t3+3*t2)*p1 + (t3-t2)*m1;


//            int cycles = 1;
//            return (float) Math.sin(2 * cycles * Math.PI * input);
        }
    }



}