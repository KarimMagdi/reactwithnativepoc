package com.reactwithnativepoc;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.reactwithnativepoc.customeviews.NetperformViewManager;
import com.reactwithnativepoc.customeviews.ProgressBarViewManager;
import com.reactwithnativepoc.customeviews.ReactImageManager;
import com.reactwithnativepoc.customeviews.VovViewManager;
import com.reactwithnativepoc.rnmodules.RNNetperformModule;
import com.reactwithnativepoc.rnmodules.RNSharedPreferencesModule;
import com.reactwithnativepoc.rnmodules.RNSplashModule;
import com.reactwithnativepoc.rnmodules.RNToastModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by karim on 10/3/17.
 */

public class ModuleRegister implements ReactPackage {


    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> lstViewManagers = new ArrayList<ViewManager>();
        lstViewManagers.add(new ProgressBarViewManager());
        lstViewManagers.add(new VovViewManager());
        lstViewManagers.add(new NetperformViewManager());


        //lstViewManagers.add(new ReactImageManager());
//        return Collections.<ViewManager>singletonList(
//                new VovViewManager()
//        );
        return lstViewManagers;
    }

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new RNToastModule(reactContext));
        modules.add(new RNSplashModule(reactContext));
        modules.add(new RNSharedPreferencesModule(reactContext));


        modules.add(new RNNetperformModule(reactContext));
       // modules.add(new SharedPrefereneModule(reactContext));


        return modules;
    }




}
