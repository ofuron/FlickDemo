package com.example.olivier.flickdemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import java.util.ArrayList;

@AutoValue
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = AutoValue_FlickPhotos.Builder.class)
public abstract class FlickPhotos implements Serializable{

  public abstract ArrayList<FlickPhoto> photo();

  @AutoValue.Builder
  @JsonPOJOBuilder(withPrefix = "")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
  public static abstract class Builder {

    public abstract FlickPhotos.Builder photo(ArrayList<FlickPhoto> photo);

    public abstract FlickPhotos build();
  }

}
