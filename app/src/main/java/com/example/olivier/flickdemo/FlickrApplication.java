package com.example.olivier.flickdemo;

import android.app.Application;

/**
 * Created by olivier on 11/30/16.
 */
public class FlickrApplication extends Application {

  private AppComponent mAppComponent;

  @Override public void onCreate() {
    super.onCreate();

    mAppComponent = DaggerAppComponent.builder()
        .flickNetModule(new FlickNetModule())
        .build();
  }
}
