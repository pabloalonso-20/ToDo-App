package com.wozu.todoApp.Repo;

import com.wozu.todoApp.Model.TodoListModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TodoListRepo extends CrudRepository<TodoListModel, UUID> {

    Optional<TodoListModel> findTodoListByTitle(String title);
    Optional<TodoListModel> deleteTodoListByTitle(String title);

}
