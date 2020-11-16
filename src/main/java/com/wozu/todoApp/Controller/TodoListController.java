package com.wozu.todoApp.Controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.wozu.todoApp.Model.TodoListModel;
import com.wozu.todoApp.Service.TodoListService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {

    private final TodoListService todoListService;

    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/get/{title}")
    public Optional<TodoListModel> getTodoListById(@PathVariable String title){
        return todoListService.getTodoListByTitle(title);
    }

    @GetMapping("/get/all")
    public Iterable<TodoListModel> getAllTodoLists(){
        return todoListService.getAllTodoLists();
    }

    @PostMapping("/post")
    public JSONObject postTodoList(@RequestBody TodoListModel todoList){
        return todoListService.postTodoList(todoList);
    }

    @PutMapping("/put/{title}")
    public JSONObject putTodoListByTitle(@PathVariable String title, @RequestBody TodoListModel newTodoList){
//        logger.debug("Request Body", newTodoList);
        return todoListService.updateTodoListByTitle(title,newTodoList);
    }

    @DeleteMapping("/delete/{title}")
    public JSONObject deleteTodoListByTitle(@PathVariable String title){
        return todoListService.deleteTodoListByTitle(title);
    }

    @DeleteMapping("/delte/all")
    public JSONObject deleteAllTodoLists(){
        return todoListService.deleteAllTodoLists();
    }

}
