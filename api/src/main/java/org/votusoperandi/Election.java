package org.votusoperandi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Election {
    private static final AtomicLong counter = new AtomicLong();
    @JsonProperty
    private Long id;
    @JsonProperty
    private String subject;
    @JsonProperty
    private List<ElectionOption> options = new ArrayList<>();

    public Election(String subject, String...options) {
        id = counter.incrementAndGet();
        this.subject = subject;
        this.options = Arrays.asList(options).stream().map(s -> new ElectionOption (s)).collect(Collectors.toList());
    }

}