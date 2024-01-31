package com.bb.planner;

import com.bb.planner.models.Status;
import com.bb.planner.models.Task;
import com.bb.planner.services.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

@SpringBootApplication
public class PlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TaskService taskService) {

		return runner -> {
			createTask(taskService);
		};
	}

	private void createTask(TaskService taskService) {

		Task task1 = new Task("Api testing", "Check if the api is working correctly", LocalDate.now(), Status.IN_PROGRESS);
		Task task2 = new Task("DB testing", "Check the DB connection", LocalDate.now().plusDays(1), Status.TODO);
		Task task3 = new Task("Authentication testing", "Check if the user data are saved correctly", LocalDate.now().minusDays(1), Status.DONE);

		taskService.addTask(task1);
		taskService.addTask(task2);
		taskService.addTask(task3);
	}
}
