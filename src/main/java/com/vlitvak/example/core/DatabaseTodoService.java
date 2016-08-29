package com.vlitvak.example.core;

import com.vlitvak.example.api.Todo;

public class DatabaseTodoService implements TodoService {

  public Todo findById(String id) {
    return new Todo(id, "content from db");
  }

}
