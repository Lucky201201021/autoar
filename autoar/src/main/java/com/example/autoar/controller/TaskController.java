package com.example.autoar.controller;

import com.example.autoar.model.Task;
import com.example.autoar.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Разрешить запросы с фронтенда
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // 1. Получить все задачи
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 2. Создать задачу (Только EMPLOYER)
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // 3. Удалить задачу (Только EMPLOYER)
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

    // 4. Взять задачу (Для EMPLOYEE) - смена статуса
    @PutMapping("/{id}/take")
    public Task takeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus("TAKEN");
        return taskRepository.save(task);
    }
}