package fgc.tdc18mvp1;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class FrescoLoader extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}