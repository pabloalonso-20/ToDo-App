package com.wozu.todoApp.Service;

import com.wozu.todoApp.Model.TaskModel;
import com.wozu.todoApp.Model.TodoListModel;
import com.wozu.todoApp.Repo.TaskRepo;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    final TaskRepo taskRepo;

    public TaskServiceImpl(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    @Override
    public Optional<TaskModel> getTaskById(UUID id) {
        return taskRepo.findById(id);
    }


    @Override
    public Iterable<TaskModel> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public JSONObject deleteAllTasks() {
        taskRepo.deleteAll();

        JSONObject response = new JSONObject();
        response.put("message","deleted all tasks");
        return response;
    }

    @Override
    public JSONObject deleteTaskById(UUID id, TaskModel list) {
        taskRepo.deleteById(id);

        JSONObject response = new JSONObject();
        response.put("message"," deleted task");
        return response;
    }

    @Override
    public JSONObject updateTaskById(UUID id, TaskModel newTask) {
        Optional<TaskModel> optionalTaskModel = taskRepo.findById(id);
        optionalTaskModel.map(taskModel -> {
            taskModel.setDescription(newTask.getDescription());
            taskModel.setComplete(newTask.getComplete());
            return taskModel;
        });

        JSONObject response = new JSONObject();
        response.put("message","updated task");
        return response;
    }

    @Override
    public JSONObject postTask(TaskModel TaskModel) {
        return null;
    }
}
