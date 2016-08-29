package com.vlitvak.example;

import com.vlitvak.example.core.TodoService;

public interface ExampleAppComponent {

  public TodoService provideTodoService();
  
  //public static TodoService provideTodoService() {
    //return new DatabaseTodoService();
  //}

}
