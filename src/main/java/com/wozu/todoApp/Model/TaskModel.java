package com.wozu.todoApp.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "todoList_id")
    private TodoListModel todoListModel;

    private String description;
    private Boolean isComplete = false;

    public TaskModel(TodoListModel todoListModel, String clean_room) {
    }

    public UUID getId() {
        return id;
    }

    public TodoListModel getTodoListModel() {
        return todoListModel;
    }

    public void setTodoListModel(TodoListModel todoListModel) {
        this.todoListModel = todoListModel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "id=" + id +
                ", todoListModel=" + todoListModel +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
