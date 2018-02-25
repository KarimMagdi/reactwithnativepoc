package com.reactwithnativepoc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.react.bridge.ReactApplicationContext;
import com.reactwithnativepoc.R;
import com.vfg.splash.SplashActivity;
import com.vfg.splash.SplashFragment;
import com.vfg.splash.models.BackgroundMode;
import com.vfg.splash.models.SplashScreenConfiguration;

public class CoreSplash extends SplashActivity {



    @Override
    protected void onViewCreated() {
        SplashScreenConfiguration splashScreenConfiguration = new SplashScreenConfiguration();
        splashScreenConfiguration.setBackgroundMode(BackgroundMode.NIGHT);
        splashScreenConfiguration.setBackgroundImageResourceId(R.drawable.vfg_commonui_evening_bg);
        updateSplashScreenConfiguration(splashScreenConfiguration);
        startSplashAnimation(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CoreSplash.this, LoginActivity.class);
                navigateToNextActivity(intent);

            }
        });

        //SplashFragment splashFragment = SplashFragment.getAnimatedSplashFragment(4000, splashScreenConfiguration);

    }
}

