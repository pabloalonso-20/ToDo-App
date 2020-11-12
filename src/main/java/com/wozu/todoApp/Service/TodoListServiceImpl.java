package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TodoListModel;
import com.wozu.todoApp.Repo.TodoListRepo;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TodoListServiceImpl implements TodoListService{

    TodoListRepo todoListRepo;

    public TodoListServiceImpl(TodoListRepo todoListRepo){
        this.todoListRepo = todoListRepo;
    }


    @Override
    public Optional<TodoListModel> getTodoListById(UUID id) {
        return todoListRepo.findById(id);
    }

    @Override
    public Optional<TodoListModel> getTodoListByTitle(String title) {
        return todoListRepo.findTodoListByTitle(title);
    }

    @Override
    public Iterable<TodoListModel> getAllTodoLists() {
        return todoListRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTodoLists() {
        JSONObject response = new JSONObject();
        response.put("message","deleted all todo lists");
        return response;
    }

    @Override
    public JSONObject deleteTodoListById(UUID id, TodoListModel list) {
        todoListRepo.deleteById(id);

        JSONObject response = new JSONObject();
        response.put("message","deleted all todo list");
        return response;
    }

    @Override
    public JSONObject updateTodoListById(UUID id, TodoListModel newTodoList) {
        Optional<TodoListModel> optionalTodoListModel = todoListRepo.findById(id);
        optionalTodoListModel.map(todoListModel -> {
            todoListModel.setTitle(newTodoList.getTitle());
            todoListModel.setTasks(newTodoList.getTasks());
            return todoListModel;
        });

        JSONObject response = new JSONObject();
        response.put("message","updated all todo list");
        return response;
    }

    @Override
    public JSONObject postTodoList(TodoListModel todoListModel) {
        todoListRepo.save(todoListModel);

        JSONObject response =  new JSONObject();
        response.put("message", "posted todo list!");
        return response;

    }
}
