package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TodoListModel;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public interface TodoListService {

    //get one by id
    Optional<TodoListModel>getTodoListById(UUID id);

    //get one by title
    Optional<TodoListModel>getTodoListByTitle(String title);

    //get all
    Iterable<TodoListModel> getAllTodoLists();

    //delete all
    JSONObject deleteAllTodoLists();

    //delete by id
    JSONObject deleteTodoListById(UUID id, TodoListModel list);

    //update by id
    JSONObject updateTodoListById(UUID id, TodoListModel list);

    //post
    JSONObject postTodoList(TodoListModel todoListModel);
}
