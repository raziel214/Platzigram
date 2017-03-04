package com.platzi.platzigram;

import android.app.Application;
import android.provider.SyncStateContract;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.platzi.platzigram.utils.Constants;

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

        FirebaseStorage storage=FirebaseStorage.getInstance();
        storageReference=storage.getReferenceFromUrl(Constants.FIREBASE_STORAGE_URL);


    }
    public StorageReference getStorageReference(){
        return storageReference;
    }





}
