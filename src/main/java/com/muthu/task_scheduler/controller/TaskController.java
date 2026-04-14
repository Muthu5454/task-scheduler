package com.muthu.task_scheduler.controller;

import com.muthu.task_scheduler.exception.ApiResponse;
import com.muthu.task_scheduler.model.Task;
import com.muthu.task_scheduler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<ApiResponse<Task>>
    createTask(@RequestBody Task task) {
        Task created =
                taskService.createTask(task);
        return ResponseEntity.ok(
                ApiResponse.success(
                        created,
                        "Task created successfully!"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse
            <List<Task>>> getAllTasks() {
        List<Task> tasks =
                taskService.getAllTasks();
        return ResponseEntity.ok(
                ApiResponse.success(
                        tasks,
                        "Tasks retrieved successfully!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>>
    getTaskById(@PathVariable Long id) {
        Task task =
                taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.ok(
                    ApiResponse.error(
                            "Task not found!"));
        }
        return ResponseEntity.ok(
                ApiResponse.success(
                        task,
                        "Task found successfully!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>
    deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Deleted",
                        "Task deleted successfully!"));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Task>>
    updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        Task task = taskService
                .updateTaskStatus(id, status);
        return ResponseEntity.ok(
                ApiResponse.success(
                        task,
                        "Status updated successfully!"));
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<ApiResponse<List<Task>>>
    getTasksByPriority(
            @PathVariable Task.Priority priority) {
        List<Task> tasks = taskService
                .getTasksByPriority(priority);
        return ResponseEntity.ok(
                ApiResponse.success(tasks,
                        "Tasks fetched by priority!"));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<Task>>>
    getTasksByStatus(
            @PathVariable String status) {
        List<Task> tasks = taskService
                .getTasksByStatus(status);
        return ResponseEntity.ok(
                ApiResponse.success(tasks,
                        "Tasks fetched by status!"));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Task>>>
    searchTasks(
            @RequestParam String name) {
        List<Task> tasks = taskService
                .searchTasks(name);
        return ResponseEntity.ok(
                ApiResponse.success(tasks,
                        "Search results!"));
    }
}