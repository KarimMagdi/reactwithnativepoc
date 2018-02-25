package com.reactwithnativepoc.customeviews;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ColorUtil;
import com.vfg.vov.VovView;
import com.vfg.vov.model.VovGreetingModel;
import com.vfg.vov.model.VovMessage;
import com.vfg.vov.model.VovMessageType;
import com.vfg.vov.model.VovWelcomeMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karimmagdy on 10/5/17.
 */

public class VovViewManager extends SimpleViewManager<VovView> {

    public static final String REACT_CLASS = "Vov";
    private ThemedReactContext ctx;


    public static final String PROP_WIDTH = "width";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected VovView createViewInstance(ThemedReactContext reactContext) {
        ctx = reactContext;
        VovView vovView = new  VovView(reactContext);

        ArrayList<VovMessage> lstVovMessages = new ArrayList<>();


        VovWelcomeMessage vovWelcomeMessage = new VovWelcomeMessage();
        vovWelcomeMessage.setAppName("Ana Vodafone");
        vovWelcomeMessage.setUsername("Karim");
        vovWelcomeMessage.setMessageBody("Welcome");
        vovWelcomeMessage.setType(VovMessageType.WELCOME_MESSAGE);

        VovGreetingModel goodMorning = new VovGreetingModel();
        goodMorning.setGreetingText("Good Morning");
        goodMorning.setStartInterval(1);
        goodMorning.setEndInterval(6);
        vovWelcomeMessage.setMorningGreetingModel(goodMorning);

        VovGreetingModel goodAfternoon = new VovGreetingModel();
        goodMorning.setGreetingText("Goog Evening");
        goodMorning.setStartInterval(7);
        goodMorning.setEndInterval(12);
        vovWelcomeMessage.setAfternoonGreetingModel(goodAfternoon);

        VovGreetingModel goodEvening = new VovGreetingModel();
        goodMorning.setGreetingText("Good Evening");
        goodMorning.setStartInterval(12);
        goodMorning.setEndInterval(18);
        vovWelcomeMessage.setEveningGreetingModel(goodEvening);

        lstVovMessages.add(vovWelcomeMessage);
        vovView.viewVovMessages(lstVovMessages);

        vovView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //vovView.setBackgroundColor(Color.GRAY);
        return vovView;
    }


}
