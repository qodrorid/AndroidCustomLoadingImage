package id.or.qodr.customimagesloading;

import android.content.Context;
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
    private Context context;
    private ImageView ivLoading;

    public CustomImageProgress(Context context, ImageView ivLoading) {
        this.context = context;
        this.ivLoading = ivLoading;
    }

    public CustomImageProgress(Builder builder) {
        this.builder = builder;
    }

    public void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_rotate);
        animation.setRepeatMode(Animation.INFINITE);
        ivLoading.startAnimation(animation);
        return null;
    }

    public void stopAnimation(){
        ivLoading.clearAnimation();
    }

    public static class Builder{

        private static int repeatMode;
        private Context context;

        public Builder(Context context) {
            this.context = context;
        }

        private Animation animation;
        private ImageView image_view;


        public Builder repeatMode(@NonNull int animation){
            repeatMode =animation;
            return this;
        }

        public Builder imageView(@NonNull ImageView imageView){
            this.image_view =imageView;
            return this;
        }

        @UiThread
        public CustomImageProgress build() {
            animation = AnimationUtils.loadAnimation(context, R.anim.animation_rotate);

            if (repeatMode!=0) {
                animation.setRepeatMode(Builder.repeatMode);
            }else{
                animation.setRepeatMode(Animation.INFINITE);
            }
            return new CustomImageProgress(this);
        }

        public Builder start(){
            image_view.setAnimation(animation);
            animation.start();
            return this;
        }

    }


}
