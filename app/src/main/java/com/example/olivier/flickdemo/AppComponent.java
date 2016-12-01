package com.example.olivier.flickdemo;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {FlickNetModule.class})
public interface AppComponent {
  void inject(FlickrActivity activity);
}
