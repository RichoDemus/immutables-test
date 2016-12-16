package com.richodemus.test.immutables;


import com.richodemus.test.immutables.dto.ImmutableMessage;
import io.dropwizard.testing.DropwizardTestSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {
    private DropwizardTestSupport<EmptyConfiguration> target;

    @Before
    public void setUp() throws Exception {
        target = new DropwizardTestSupport<>(Main.class, new EmptyConfiguration());
        target.before();
    }

    @After
    public void tearDown() throws Exception {
        target.after();
    }

    @Test
    public void testJacksonSerializationFromObject() {
        final ImmutableMessage result = ClientBuilder.newClient()
                .target("http://localhost:" + target.getLocalPort())
                .path("hello")
                .request()
                .post(Entity.json(ImmutableMessage.of("this is the message")), ImmutableMessage.class);

        assertThat(result).isEqualTo(ImmutableMessage.of("this is the message"));
    }

    @Test
    public void testJacksonSerializationFromString() throws Exception {
        //language=JSON
        final String json = "\"Hello there\"";
        final String result = ClientBuilder.newClient()
                .target("http://localhost:" + target.getLocalPort())
                .path("hello")
                .request()
                .post(Entity.json(json), String.class);

        assertThat(result).isEqualTo(json);
    }
}
