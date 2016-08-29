package com.vlitvak.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.HashMap;

import com.vlitvak.example.health.TemplateHealthCheck;
import com.vlitvak.example.resources.TodoResource;

public class ExampleApplication extends Application<ExampleConfiguration> {

    private ExampleAppComponent chosenAppComponent;

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
      ExampleAppComponent component = getAppComponent(configuration);
      setupEndpoints(configuration, environment, component);
      setupHealthChecks(configuration, environment);
    }

    private void setupEndpoints(
        ExampleConfiguration configuration, 
        Environment environment, 
        ExampleAppComponent exampleAppComponent) {

      final TodoResource todoResource = new TodoResource(
        exampleAppComponent.provideTodoService()
      );

      environment.jersey().register(todoResource);

    }

    private void setupHealthChecks(
        ExampleConfiguration configuration, Environment environment) {

      final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(configuration.getTemplate());

      environment.healthChecks().register("template", healthCheck);

    }

    private ExampleAppComponent getAppComponent(ExampleConfiguration configuration) {

      if (chosenAppComponent != null) {
        return chosenAppComponent;
      }

      HashMap<String, ExampleAppComponent> componentMapping =
        new HashMap<String, ExampleAppComponent>();

      RealComponent realComponent = DaggerRealComponent.builder().build();
      DummyComponent dummyComponent = DaggerDummyComponent.builder().build(); 

      componentMapping.put("production", realComponent);
      componentMapping.put("test", dummyComponent);

      chosenAppComponent = componentMapping.get(configuration.getEnv());

      return chosenAppComponent;

    }

}

