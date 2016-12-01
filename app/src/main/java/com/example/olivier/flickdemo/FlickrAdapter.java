package com.example.olivier.flickdemo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class FlickrAdapter extends RecyclerView.Adapter<FlickrAdapter.FlickrItemViewHolder> {

  private Context mContext;
  private ArrayList<FlickPhotos> mPhotos;

  public FlickrAdapter(FlickrActivity activity) {
    mContext = activity;
  }

  @Override public FlickrItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View v = inflater.inflate(R.layout.flickr_item, parent);
    FlickrItemViewHolder holder = new FlickrItemViewHolder(v);
    return holder;
  }

  @Override public int getItemCount() {
    return mPhotos.size();
  }

  @Override public void onBindViewHolder(FlickrItemViewHolder holder, int position) {
    FlickPhotos photo = mPhotos.get(position);
    String url = "https://farm"
        + photo.farm()
        + ".staticflickr.com/"
        + photo.server()
        + "/"
        + photo.id()
        + "_"
        + photo.secret()
        + ".jpg";

    Glide.with(mContext)
        .load(Uri.parse(url))
        .fitCenter()
        .dontAnimate()
        .into(holder.mImageView);
  }

  public void updateData(ArrayList<FlickPhotos> photos) {
    mPhotos = photos;
    notifyDataSetChanged();
  }

  // THE VIEW HOLDER
  public class FlickrItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;

    public FlickrItemViewHolder(View itemView) {
      super(itemView);
      mImageView = (ImageView) itemView.findViewById(R.id.image);
    }

  }


}
