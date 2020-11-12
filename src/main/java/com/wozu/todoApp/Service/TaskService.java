package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TaskModel;
import com.wozu.todoApp.Model.TodoListModel;
import org.json.simple.JSONObject;

import java.util.Optional;
import java.util.UUID;

public interface TaskService {
    //get one by id
    Optional<TaskModel> getTaskById(UUID id);

    //get all
    Iterable<TaskModel> getAllTasks();

    //delete all
    JSONObject deleteAllTasks();

    //delete by id
    JSONObject deleteTaskById(UUID id, TaskModel list);

    //update by id
    JSONObject updateTaskById(UUID id, TaskModel list);

    //post
    JSONObject postTask(TaskModel taskModel);
}
