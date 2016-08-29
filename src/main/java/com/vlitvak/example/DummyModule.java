package com.vlitvak.example;

//import com.vlitvak.example.core.DummyTodoService;
//import com.vlitvak.example.core.TodoService;

import com.vlitvak.example.core.DummyTodoService;
import com.vlitvak.example.core.TodoService;

import dagger.Module;
//import dagger.Provides;
import dagger.Provides;

@Module
public class DummyModule {

  @Provides static TodoService provideTodoService() {
    return new DummyTodoService();
  }

  //@Provides static Pump providePump(Thermosiphon pump) {
    //return pump;
  //}
}
