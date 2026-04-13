package com.muthu.task_scheduler.service;

import com.muthu.task_scheduler.model.Task;
import com.muthu.task_scheduler.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    // Create new task
    public Task createTask(Task task) {
        log.info("Creating new task: {}",
                task.getTaskName());
        task.setStatus("SCHEDULED");
        task.setCreatedAt(
                LocalDateTime.now());
        Task saved =
                taskRepository.save(task);
        log.info("Task created with id: {}",
                saved.getId());
        return saved;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        List<Task> tasks =
                taskRepository.findAll();
        log.info("Found {} tasks",
                tasks.size());
        return tasks;
    }

    // Get task by id
    public Task getTaskById(Long id) {
        log.info(
                "Fetching task with id: {}", id);
        return taskRepository
                .findById(id)
                .orElse(null);
    }

    // Delete task
    public void deleteTask(Long id) {
        log.info(
                "Deleting task with id: {}", id);
        taskRepository.deleteById(id);
        log.info(
                "Task deleted successfully: {}",
                id);
    }

    // Update task status
    public Task updateTaskStatus(
            Long id, String status) {
        log.info(
                "Updating task {} status to {}",
                id, status);
        Task task = taskRepository
                .findById(id).orElse(null);
        if (task != null) {
            task.setStatus(status);
            task.setLastExecutedAt(
                    LocalDateTime.now());
            Task updated =
                    taskRepository.save(task);
            log.info(
                    "Task {} status updated to {}",
                    id, status);
            return updated;
        }
        log.warn(
                "Task not found with id: {}", id);
        return null;
    }
}