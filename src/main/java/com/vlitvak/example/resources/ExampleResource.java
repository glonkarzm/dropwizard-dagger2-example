package com.vlitvak.example.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.vlitvak.example.api.Saying;
import com.vlitvak.example.api.Todo;
import com.vlitvak.example.core.TodoService;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
    private final AtomicLong counter;
    private final String fromConfig;
    private final TodoService todoService;

    public ExampleResource(
          String template, String defaultName, String fromConfig, TodoService todoService) {
        this.counter = new AtomicLong();
        this.fromConfig = fromConfig;
        this.todoService = todoService;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") String name) throws Exception {
        if (name == null || name.equals("")) {
          throw new Exception("name is required!");
        }

        Todo todo = todoService.findById("1");

        return new Saying(
          counter.incrementAndGet(), 
          todo.getContent(),
          fromConfig
        );
    }
} 
