package com.muthu.task_scheduler;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Task Scheduler API",
				version = "1.0",
				description = "Distributed Task Scheduler using Spring Boot and Quartz"
		)
)
public class TaskSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				TaskSchedulerApplication.class,
				args);
	}
}