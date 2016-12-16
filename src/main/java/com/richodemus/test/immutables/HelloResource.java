package com.richodemus.test.immutables;

import com.richodemus.test.immutables.dto.ImmutableMessage;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @POST
    public Response hello(ImmutableMessage message) {
        return Response.ok(ImmutableMessage.copyOf(message), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
