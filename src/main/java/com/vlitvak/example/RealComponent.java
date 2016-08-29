package com.vlitvak.example;

import javax.inject.Singleton;

//import com.vlitvak.example.core.TodoService;

import dagger.Component;

@Singleton
@Component(modules = {RealModule.class})
public interface RealComponent extends ExampleAppComponent {

  //public TodoService getTodoService();

}

