package com.example.olivier.flickdemo;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by olivier on 11/30/16.
 */
public interface FlickClient {

  @GET("?method=flickr.interestingness.getList&api_key=cc46091d1ed44d14e3a937a28907154f&format=json&nojsoncallback=1") Call<FlickResponse> interesting();

}
