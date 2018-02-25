package com.reactwithnativepoc.rnmodules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactwithnativepoc.activities.LoginActivity;

import javax.annotation.Nonnull;

/**
 * Created by karim on 10/3/17.
 */

public class RNToastModule extends ReactContextBaseJavaModule {

    Context mContext ;

    public RNToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
    }

    @ReactMethod
    public String getName() {
        return "RNToastModule";
    }

    @ReactMethod
    public void sayHello() {
        Toast.makeText(mContext,"hello from android",Toast.LENGTH_SHORT).show();

    }

    @ReactMethod
    void navigateToExample() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @ReactMethod
    void dialNumber(@Nonnull String number) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        mContext.startActivity(intent);
    }

    @ReactMethod
    void getActivityName(@Nonnull Callback callback) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
            callback.invoke(activity.getClass().getSimpleName());
        }
    }

}
