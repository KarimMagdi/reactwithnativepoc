package com.reactwithnativepoc.customeviews;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.reactwithnativepoc.R;
import com.vfg.fragments.VFFragment;
import com.vfg.netperform.NetPerform;

import java.util.HashMap;

/**
 * Created by karimmagdy on 10/9/17.
 */

public class NetperformViewManager extends SimpleViewManager<FrameLayout> {

    ReactContext reactContext ;

    @Override
    public String getName() {
        return "Netperform";
    }

    @Override
    protected FrameLayout createViewInstance(ThemedReactContext reactContext) {
        this.reactContext = reactContext;


        FrameLayout view = new FrameLayout(reactContext);
        view.setId(View.generateViewId());


        FragmentManager fragmentManager = reactContext.getCurrentActivity().getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        initNetPerformConfiguration(null);
        VFFragment vfFragment  = NetPerform.getNetworkUsageFragment(reactContext,"My Vodafone","11111",null, R.string.action_sign_in);
        fragmentTransaction.add(view.getId(), vfFragment);
        fragmentTransaction.commit();



        return view;
    }

    private void initNetPerformConfiguration(HashMap<String, String> contentMap) {
        try {
            NetPerform.initConfiguration(reactContext, R.string.configuration_file_name, contentMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
