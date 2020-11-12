package com.wozu.todoApp.Model;

import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="todo_lists")
public class TodoListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;


    @OneToMany(mappedBy = "todoList",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Task> tasks;




    //constructors
    public TodoListModel(){
    }
    public TodoListModel(String title){
        this.title = title;
    }


    //getters and setters
    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
