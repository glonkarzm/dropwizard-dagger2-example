package com.vlitvak.example;

import com.vlitvak.example.core.DatabaseTodoService;
import com.vlitvak.example.core.TodoService;

import dagger.Module;
import dagger.Provides;

@Module
public class RealModule {

  @Provides public static TodoService provideTodoService() {
    return new DatabaseTodoService();
  }

  //@Provides static Pump providePump(Thermosiphon pump) {
    //return pump;
  //}
}
