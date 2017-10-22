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
        ImageView imageViewLoading1 = (ImageView) findViewById(R.id.ivLoadingSnow1);
        ImageView imageViewLoading2 = (ImageView) findViewById(R.id.ivLoadingSnow2);
        ImageView imageViewLoading3 = (ImageView) findViewById(R.id.ivLoadingSnow3);
        ImageView imageViewLoading4 = (ImageView) findViewById(R.id.ivLoadingSnow4);

        customImageProgress = new CustomImageProgress(this, imageViewLoading);

//        startAnimation();

        CustomImageProgress customImageProgress = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading)
                .build();
        customImageProgress.startAnimation();

        CustomImageProgress customImageProgress1 = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading1)
                .animation(R.anim.animation_callback)
                .build();
        customImageProgress1.startAnimation();

        CustomImageProgress customImageProgress2 = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading2)
                .animation(R.anim.animation_callback_fast)
                .build();
        customImageProgress2.startAnimation();

        CustomImageProgress customImageProgress3 = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading3)
                .animation(R.anim.animation_slow)
                .build();
        customImageProgress3.startAnimation();

        CustomImageProgress customImageProgress4 = new CustomImageProgress.Builder(this)
                .imageView(imageViewLoading4)
                .animation(R.anim.animation_oppsite_clockwise)
                .build();
        customImageProgress4.startAnimation();


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
