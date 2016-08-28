package com.vlitvak.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.vlitvak.example.resources.ExampleResource;
import com.vlitvak.example.health.TemplateHealthCheck;

public class ExampleApplication extends Application<ExampleConfiguration> {
    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ExampleConfiguration configuration,
                    Environment environment) {
      final ExampleResource resource = new ExampleResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
      );
      final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(configuration.getTemplate());

      
      environment.healthChecks().register("template", healthCheck);
      environment.jersey().register(resource);
    }

}

