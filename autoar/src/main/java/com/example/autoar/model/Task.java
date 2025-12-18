package com.example.autoar.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String reward;      // Например "5000 ₸"
    private String time;        // Например "2h"
    private String complexity;  // Low, Medium, High

    private LocalDate taskDate; // Дата задачи (2025-12-05)

    // Статус: OPEN (доступна), TAKEN (взята сотрудником)
    private String status = "OPEN";
}