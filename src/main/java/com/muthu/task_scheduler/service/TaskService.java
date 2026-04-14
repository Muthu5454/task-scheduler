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

    public Task createTask(Task task) {
        log.info("Creating new task: {}",
                task.getTaskName());
        task.setStatus("SCHEDULED");
        task.setCreatedAt(LocalDateTime.now());
        if (task.getPriority() == null) {
            task.setPriority(
                    Task.Priority.MEDIUM);
        }
        Task saved = taskRepository.save(task);
        log.info("Task created with id: {}",
                saved.getId());
        return saved;
    }

    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        List<Task> tasks =
                taskRepository.findAll();
        log.info("Found {} tasks",
                tasks.size());
        return tasks;
    }

    public Task getTaskById(Long id) {
        log.info(
                "Fetching task with id: {}", id);
        return taskRepository
                .findById(id)
                .orElse(null);
    }

    public void deleteTask(Long id) {
        log.info(
                "Deleting task with id: {}", id);
        taskRepository.deleteById(id);
        log.info(
                "Task deleted successfully: {}",
                id);
    }

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
            return taskRepository.save(task);
        }
        log.warn(
                "Task not found with id: {}", id);
        return null;
    }

    public List<Task> getTasksByPriority(
            Task.Priority priority) {
        log.info(
                "Fetching tasks with priority: {}",
                priority);
        return taskRepository
                .findByPriority(priority);
    }

    public List<Task> getTasksByStatus(
            String status) {
        log.info(
                "Fetching tasks with status: {}",
                status);
        return taskRepository
                .findByStatus(status);
    }

    public List<Task> searchTasks(
            String name) {
        log.info(
                "Searching tasks with name: {}",
                name);
        return taskRepository
                .findByTaskNameContaining(name);
    }
}