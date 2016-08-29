package com.vlitvak.example.core;

import com.vlitvak.example.api.Todo;

public class DummyTodoService implements TodoService {

  public Todo findById(String id) {
    return new Todo(id, "fake content");
  }

}

