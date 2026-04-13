package com.muthu.task_scheduler.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String cronExpression;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime lastExecutedAt;
}