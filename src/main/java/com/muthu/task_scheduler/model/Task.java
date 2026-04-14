package com.muthu.task_scheduler.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(
            message = "Task name cannot be empty")
    private String taskName;

    @NotBlank(
            message = "Cron expression cannot be empty")
    private String cronExpression;

    private String status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDateTime createdAt;

    private LocalDateTime lastExecutedAt;

    public enum Priority {
        HIGH,
        MEDIUM,
        LOW
    }
}