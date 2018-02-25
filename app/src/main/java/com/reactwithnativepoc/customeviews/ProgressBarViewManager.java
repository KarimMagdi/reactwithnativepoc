package com.reactwithnativepoc.customeviews;

import android.widget.ProgressBar;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by karimmagdy on 10/4/17.
 */

public class ProgressBarViewManager extends SimpleViewManager<ProgressBar> {

        public static final String REACT_CLASS = "ProgressBar";

        @Override
        public String getName() {
            return REACT_CLASS;
        }

        @Override
        protected ProgressBar createViewInstance(
                ThemedReactContext reactContext) {
            ProgressBar bar = new ProgressBar(reactContext);
            bar.setProgress(40);
            bar.setIndeterminate(true);
            return bar;
        }

    @ReactProp(name = "progress", defaultInt = 0)
    public void setProgress(ProgressBar view, int progress) {
        view.setProgress(progress);
    }

    @ReactProp(name = "indeterminate", defaultBoolean = false)
    public void setIndeterminate(ProgressBar view, boolean indeterminate) {
        view.setIndeterminate(indeterminate);
    }
}
