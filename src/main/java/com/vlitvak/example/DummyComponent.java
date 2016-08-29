package com.vlitvak.example;

//import com.vlitvak.example.core.TodoService;

import dagger.Component;

@Component(modules = {DummyModule.class})
public interface DummyComponent extends ExampleAppComponent {

  //TodoService getTodoService();

}

