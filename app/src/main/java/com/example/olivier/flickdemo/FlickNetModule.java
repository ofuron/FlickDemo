package com.example.olivier.flickdemo;

import dagger.Module;
import dagger.Provides;
import java.io.IOException;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

@Module
public class FlickNetModule {

  private static String KEY = "cd88c346c3da81aeb6ce13ec51db5c53";
  private static String SECRET = "f639944355e49d1c";

  @Singleton
  @Provides
  OkHttpOAuthConsumer provideOkHttpAuthConsumer() {
    return new OkHttpOAuthConsumer(KEY, SECRET);
  }

  @Singleton
  @Provides OkHttpClient provideOkHttpClient(final OkHttpOAuthConsumer consumer) {
    return new OkHttpClient.Builder().build();
  }

  @Singleton
  @Provides Retrofit provideRetrofit(final OkHttpClient client) {
    return new Retrofit.Builder()
        .baseUrl("https://api.flickr.com/services/rest/")
        .client(client)
        .build();
  }

  @Singleton
  @Provides FlickClient provideFlickrClient(final Retrofit retrofit) {
    return retrofit.create(FlickClient.class);
  }
}
