package com.vlitvak.example.resources;

import com.vlitvak.example.api.Saying;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {
    private final AtomicLong counter;

    public ExampleResource(String template, String defaultName) {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    //public Saying sayHello(@DefaultValue("val") @QueryParam("name") String name) {
    public Saying sayHello(@QueryParam("name") String name) throws Exception {
        System.out.println("= name ='" + name + "'");
        if (name == null || name.equals("")) {
          throw new Exception("name is required!");
        }
        String value = name;
        return new Saying(counter.incrementAndGet(), value);
    }
} 
