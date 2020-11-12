package com.wozu.todoApp;

import com.wozu.todoApp.Model.TaskModel;
import com.wozu.todoApp.Model.TodoListModel;
import com.wozu.todoApp.Repo.TaskRepo;
import com.wozu.todoApp.Repo.TodoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    static TaskRepo taskRepo;

    @Autowired
    static TodoListRepo todoListRepo;

    @Override
    public void run(String... args) throws Exception {
        seed();
    }


    public static void seed(){

        if(taskRepo.count() == 0 && todoListRepo.count() == 0){
            TodoListModel newTodoList = new TodoListModel("Chores");

            todoListRepo.save(newTodoList);

            Optional<TodoListModel> optionalTodoListModel = todoListRepo.findTodoListByTitle(newTodoList.getTitle());

            TaskModel newTask = new TaskModel(optionalTodoListModel.get(), "Clean Room");

            taskRepo.save(newTask);
        }

    }
}
