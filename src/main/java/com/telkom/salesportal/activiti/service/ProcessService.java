package com.telkom.salesportal.activiti.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.activiti.engine.task.Task;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProcessService {

	
@Autowired RuntimeService runtimeService;
	
	@Autowired private TaskService taskService;
	
	@Autowired private RepositoryService  repositoryService;
	
	

	
	public String startTheProcess( String clientId) {

	

		Map<String, Object> variables = new HashMap<>();
		//variables.put("customer", "nkosi" );
		variables.put("clientId",clientId);
        
		runtimeService.startProcessInstanceByKey("telkom-process", variables);

		return processInformation();
	}

	// fetching process and task information
	public String processInformation() {

		List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();

		StringBuilder processAndTaskInfo = new StringBuilder();
		
		processAndTaskInfo.append("Number of process definition available: "
				+ repositoryService.createProcessDefinitionQuery().count() + " | Task Details= ");

		taskList.forEach(task -> {

			processAndTaskInfo.append("ID: " + task.getId()+ ", Name: " + task.getName() + ", assignee: "
					+ task.getAssignee());
		});

		return processAndTaskInfo.toString();
	}
	// fetch task assigned to employee
		public List<Task> getTasks(String id) {
			return taskService.createTaskQuery().taskAssignee(id).list();
		}
		
		public List<Task> getAllTasks() {
			return taskService.createTaskQuery().list();
		}
		// complete the task
		public void completeTask(String taskId) {
			taskService.complete(taskId);
		}
}
