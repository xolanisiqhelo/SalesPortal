package com.telkom.salesportal.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telkom.salesportal.activiti.service.ProcessService;

@RestController	
@RequestMapping(value = "/salesportal/api")
public class ProcessController {

	
	 @Autowired private ProcessService processService;
     
		
		@PostMapping(value="/process")
		public  String startProcessIntance(@RequestParam String  clientId )
		{
			
			return processService.startTheProcess(clientId);
		}
		// Retrieve the tasks assigned to an employee
	//	@GetMapping(value = "/tasks")
//		public String getTasks(@RequestParam String assignee) {
//				List<Task> tasks = processService.getTasks(assignee);
//				return tasks.toString();
//		}
//		@GetMapping(value = "/Alltasks")
//		public String getAllTasks() {
//				List<Task> tasks = processService.getAllTasks();
//				return tasks.toString();
//		}
//
//		// Complete the task by their ID
//		@PostMapping(value = "/completetask")
//		public String completeTask(@RequestParam String taskId) {
//				processService.completeTask(taskId);
//				return "Task with id " + taskId + " has been completed!";
//		}
}
