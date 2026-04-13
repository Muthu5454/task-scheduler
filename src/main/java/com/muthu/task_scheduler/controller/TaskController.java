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

    // Create task
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

    // Get all tasks
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

    // Get task by id
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

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>>
    deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(
                ApiResponse.success(
                        "Deleted",
                        "Task deleted successfully!"));
    }

    // Update task status
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
}