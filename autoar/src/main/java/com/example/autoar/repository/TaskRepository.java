package com.example.autoar.repository;

import com.example.autoar.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Найти задачи за конкретный месяц (между датами)
    List<Task> findByTaskDateBetween(LocalDate startDate, LocalDate endDate);
}