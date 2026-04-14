package com.muthu.task_scheduler.repository;

import com.muthu.task_scheduler.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long> {

    // Find by priority
    List<Task> findByPriority(
            Task.Priority priority);

    // Find by status
    List<Task> findByStatus(String status);

    // Search by name
    List<Task> findByTaskNameContaining(
            String taskName);
}