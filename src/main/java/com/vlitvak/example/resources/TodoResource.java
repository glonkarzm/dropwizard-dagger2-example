package com.vlitvak.example.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.vlitvak.example.api.Todo;
import com.vlitvak.example.core.TodoService;

@Path("/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoResource {

    private final TodoService todoService;

    @Inject
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GET
    @Timed
    public Todo getTodo(@QueryParam("id") String id) throws Exception {
        if (id == null || id.equals("")) {
          throw new Exception("id is required!");
        }

        Todo todo = todoService.findById(id);
        return todo;
    }

} 

