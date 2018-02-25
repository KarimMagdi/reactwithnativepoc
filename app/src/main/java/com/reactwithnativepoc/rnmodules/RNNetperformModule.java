package com.reactwithnativepoc.rnmodules;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.reactwithnativepoc.R;
import com.reactwithnativepoc.activities.CoreSplash;
import com.vfg.fragments.VFFragment;
import com.vfg.netperform.NetPerform;

import java.util.HashMap;

/**
 * Created by karim on 10/3/17.
 */

public class RNNetperformModule extends ReactContextBaseJavaModule {

    Context mContext ;
    ReactApplicationContext context;
    public RNNetperformModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mContext = reactContext;
        context = getReactApplicationContext();
    }

    @Override
    public String getName() {
        return "RNNetperformModule";
    }

    @ReactMethod
    void startNetperform() {
        FrameLayout view = new FrameLayout(context);
        view.setId(View.generateViewId());

        context = getReactApplicationContext();
        FragmentManager fragmentManager = context.getCurrentActivity().getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        initNetPerformConfiguration(null);
        VFFragment vfFragment  = NetPerform.getNetworkUsageFragment(mContext,"My Vodafone","11111",null, R.string.action_sign_in);
        fragmentTransaction.add(view.getId(), vfFragment);
        fragmentTransaction.commit();
    }

    private void initNetPerformConfiguration(HashMap<String, String> contentMap) {
        try {
            NetPerform.init(context, "rocore_android_2017013101_netperform_lib_405_PREPROD.CFG");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
