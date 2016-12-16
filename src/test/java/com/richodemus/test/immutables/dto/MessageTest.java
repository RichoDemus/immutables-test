package com.richodemus.test.immutables.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {
    private static final String VALUE = "Hello World!";

    @Test
    public void instantiateUsingBuilder() throws Exception {
        final ImmutableMessage result = ImmutableMessage.builder().value(VALUE).build();
        assertThat(result.value()).isEqualTo(VALUE);
    }

    @Test
    public void instantiateUsingConstructor() throws Exception {
        final ImmutableMessage result = ImmutableMessage.of(VALUE);
        assertThat(result.value()).isEqualTo(VALUE);
    }
}
