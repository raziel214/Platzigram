package com.platzi.platzigram;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.storage.StorageReference;

/**
 * Created by desarrolladorjf on 01/03/2017.
 */

public class PlatzigramApplication extends Application {

    StorageReference storageReference;



    @Override
    public void onCreate() {


        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }





}
