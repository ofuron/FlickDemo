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
@JsonDeserialize(builder = AutoValue_FlickResponse.Builder.class)
public abstract class FlickResponse implements Serializable {

  public abstract FlickPhotos photos();

  @AutoValue.Builder
  @JsonPOJOBuilder(withPrefix = "")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
  public static abstract class Builder {

    public abstract Builder photos(FlickPhotos photos);

    public abstract FlickResponse build();
  }

  public static Builder builder() {
    return new AutoValue_FlickResponse.Builder();
  }
}

