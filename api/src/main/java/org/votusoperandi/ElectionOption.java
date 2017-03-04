package org.votusoperandi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.concurrent.atomic.AtomicLong;

public class ElectionOption {
    private static final AtomicLong counter = new AtomicLong();

    @JsonProperty
    private Long id;
    @JsonProperty
    private String description;

    public ElectionOption(String s) {
        id = counter.incrementAndGet();
        description = s;
    }
}
