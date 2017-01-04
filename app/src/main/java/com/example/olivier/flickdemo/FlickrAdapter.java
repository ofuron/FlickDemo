package com.example.olivier.flickdemo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class FlickrAdapter extends RecyclerView.Adapter<FlickrAdapter.FlickrItemViewHolder> {

  private Context mContext;
  private ArrayList<FlickPhoto> mPhotos;

  public FlickrAdapter(FlickrActivity activity) {
    mContext = activity;
  }

  @Override public FlickrItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View v = inflater.inflate(R.layout.flickr_item, parent, false);
    FlickrItemViewHolder holder = new FlickrItemViewHolder(v);
    return holder;
  }

  @Override public int getItemCount() {
    return mPhotos != null ? mPhotos.size() : 0;
  }

  @Override public void onBindViewHolder(FlickrItemViewHolder holder, int position) {
    FlickPhoto photo = mPhotos.get(position);

    if(photo != null) {
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
              .placeholder(R.mipmap.ic_launcher) // can also be a drawable
              .crossFade()
              .fitCenter()
              .into(holder.mImageView);
    } else {
      Glide.clear(holder.mImageView);
      holder.mImageView.setImageDrawable(null );
    }
  }

  public void updateData(ArrayList<FlickPhoto> photos) {
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
