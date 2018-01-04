package fgc.tdc18mvp1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {


    private static final int SPLASH_TIME_OUT1 = 3000;
    //private static final int SPLASH_TIME_OUT2 = 4000;

    ImageView splash1, splash2;

    //TextView tv_top, tv_bottom, tv_bottom_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fresco.initialize(this);
        setContentView(R.layout.activity_splash3);

        splash1 = findViewById(R.id.splash_iv_clouds);
        splash2 = findViewById(R.id.splash_iv_plane);
        /*splash2 = findViewById(R.id.splash2);
        tv_top = findViewById(R.id.tv_splash_top);
        tv_bottom = findViewById(R.id.tv_splash_bottom);
        tv_bottom_2 = findViewById(R.id.tv_splash_bottom2);

        splash2.setAlpha(0.0f);
        tv_bottom_2.setAlpha(0.0f);*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                splash1.animate()
                        .translationY(splash1.getWidth())
                        .alpha(0.0f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                splash1.setVisibility(View.GONE);
                            }
                        });
                splash2.animate()
                        .translationY(splash1.getWidth())
                        .alpha(0.0f)
                        .setDuration(500)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                splash1.setVisibility(View.GONE);
                            }
                        });


                // This method will be executed once the timer is over
                // Start your app main activity
                /*Intent i = new Intent(SplashActivity.this, OnBoardActivity.class);
                startActivity(i);*/

                startActivity(new Intent(SplashActivity.this, DashboardActivity.class));

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT1);
    }
}
