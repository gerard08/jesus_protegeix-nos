package mars.jesus_protegeix_nos;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity{
    int cucut=5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
countdown();
    }
    private void countdown(){

        new CountDownTimer(500, 1) {


            public void onTick(long millisUntilFinished) {
                ImageView logo=findViewById(R.id.mars);
                cucut=cucut+12;
                logo.setAlpha(cucut);
                            }

            public void onFinish() {
                Intent i = new Intent(Splash.this,
                        MainActivitya.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}