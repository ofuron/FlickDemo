package com.example.olivier.flickdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FlickrActivity extends AppCompatActivity {

  @Inject FlickClient mClient;

  private RecyclerView mRecyclerView;
  private FlickrAdapter mAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flickr);

    ((FlickrApplication) getApplication()).getAppComponent().inject(this);

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mAdapter = new FlickrAdapter(this);
    mRecyclerView.setAdapter(mAdapter);

    Call<FlickResponse> response = mClient.interesting();
    response.enqueue(new Callback<FlickResponse>() {
      @Override public void onResponse(Call<FlickResponse> call, Response<FlickResponse> response) {
        FlickResponse resp = response.body();
        mAdapter.updateData(resp.photos().photo());
      }

      @Override public void onFailure(Call<FlickResponse> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }
}
