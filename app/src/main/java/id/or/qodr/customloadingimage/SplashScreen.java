package id.or.qodr.customloadingimage;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import id.or.qodr.customimagesloading.CustomImageProgress;

public class SplashScreen extends AppCompatActivity {

    private CustomImageProgress customImageProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageViewLoading = (ImageView) findViewById(R.id.ivLoadingSnow);

        customImageProgress = new CustomImageProgress(this, imageViewLoading);

        startAnimation();

        CustomImageProgress customImageProgress1 = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading)
                .build().startAnimation();
    }

    private void startAnimation() {
        Toast.makeText(this, "start animation", Toast.LENGTH_SHORT).show();
        customImageProgress.startAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                customImageProgress.stopAnimation();
                Toast.makeText(SplashScreen.this, "stoped", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startAnimation();

                    }
                }, 2000);
            }
        }, 10000);
    }
}
