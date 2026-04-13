# Distributed Task Scheduler

A backend job scheduling system built with
Java, Spring Boot, and Quartz Scheduler.

## Technologies Used
- Java 17
- Spring Boot 3.5.13
- Quartz Scheduler
- MySQL
- Spring Data JPA
- Swagger UI
- Lombok

## Features
- Create and manage scheduled tasks
- REST APIs for task management
- Automatic task execution using Quartz
- Task execution history tracking
- Global exception handling
- Swagger UI documentation

## API Endpoints
| Method | URL | Description |
|--------|-----|-------------|
| POST | /api/tasks | Create task |
| GET | /api/tasks | Get all tasks |
| GET | /api/tasks/{id} | Get task by id |
| PUT | /api/tasks/{id}/status | Update status |
| DELETE | /api/tasks/{id} | Delete task |

## How to Run
1. Clone the repository
2. Configure MySQL database
3. Run TaskSchedulerApplication.java
4. Open Swagger UI: http://localhost:8080/swagger-ui/index.html
