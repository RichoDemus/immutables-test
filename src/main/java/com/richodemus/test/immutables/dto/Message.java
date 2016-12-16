package com.richodemus.test.immutables.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableMessage.class)
@JsonDeserialize(as = ImmutableMessage.class)
public abstract class Message {
    @Value.Parameter
    @JsonValue
    public abstract String value();
}
