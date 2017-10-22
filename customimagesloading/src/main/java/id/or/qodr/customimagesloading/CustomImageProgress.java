package id.or.qodr.customimagesloading;

import android.content.Context;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by zainal on 1/25/17 - 9:07 AM.
 * Zainal Fahrudin
 * fnzainal@gmail.com
 */
public class CustomImageProgress{

    private Builder builder;
    private static Context context;
    private static ImageView imageView;
    private static int animation_layout = 0;
    private static int repeatMode;

    public CustomImageProgress(Context context, ImageView imageView) {
        CustomImageProgress.context = context;
        CustomImageProgress.imageView = imageView;
    }

    public CustomImageProgress(Builder builder) {
        this.builder = builder;
    }

    public void startAnimation(){
        if (animation_layout==0){
            animation_layout = R.anim.animation_clockwise;
        }
        Animation animation = AnimationUtils.loadAnimation(context, animation_layout);
        animation.setRepeatMode(Animation.INFINITE);
        imageView.startAnimation(animation);
    }

    public void stopAnimation(){
        imageView.clearAnimation();
    }

    /**
     * builder animation
     */
    public static class Builder{




        public Builder(Context contexts) {
            context = contexts;
        }

        private Animation animation;


        public Builder repeatMode(@NonNull int repeat_mode){
            repeatMode =repeat_mode;
            return this;
        }

        public Builder imageView(@NonNull ImageView image_view){
            imageView =image_view;
            return this;
        }

        public Builder animation(@NonNull int layout_animation){
            animation_layout =layout_animation;
            return this;
        }

        @UiThread
        public CustomImageProgress build() {
            if (animation_layout==0){
                animation_layout = R.anim.animation_clockwise;
            }

            animation = AnimationUtils.loadAnimation(context, animation_layout);

            if (repeatMode!=0) {
                animation.setRepeatMode(repeatMode);
            }else{
                animation.setRepeatMode(Animation.INFINITE);
            }

            return new CustomImageProgress(this);
        }

        public Builder start(){
            imageView.setAnimation(animation);
            animation.start();
            return this;
        }

    }


}
