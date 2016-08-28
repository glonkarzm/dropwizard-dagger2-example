package com.vlitvak.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import com.google.common.base.MoreObjects;

public class Saying {
    private long id;

    @Length(max = 3)
    private String content;

    private String fromConfig;

    public Saying() {
        // Jackson deserialization
    }

    public Saying(long id, String content, String fromConfig) {
        this.id = id;
        this.content = content;
        this.fromConfig = fromConfig;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public String getFromConfig() {
        return this.fromConfig;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
        .add("id", getId())
        .add("content", getContent())
        .toString();
    }
}
