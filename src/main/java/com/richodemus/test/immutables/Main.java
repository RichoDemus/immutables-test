package com.richodemus.test.immutables;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Main extends Application<EmptyConfiguration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(EmptyConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(HelloResource.class);
    }
}
