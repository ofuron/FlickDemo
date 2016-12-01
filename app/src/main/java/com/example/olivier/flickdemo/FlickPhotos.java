package com.example.olivier.flickdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import java.io.Serializable;

@AutoValue
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = AutoValue_FlickPhotos.Builder.class)
public abstract class FlickPhotos implements Serializable{

  public abstract String id();

  public abstract String secret();

  public abstract String farm();

  public abstract String server();

  @AutoValue.Builder
  public static abstract class Builder {

    public abstract Builder id(String id);

    public abstract Builder secret(String secret);

    public abstract Builder farm(String farm);

    public abstract Builder server(String server);

    public abstract FlickPhotos build();
  }

}
