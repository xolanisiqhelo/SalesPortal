package com.telkom.salesportal.activiti.service;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telkom.salesportal.activiti.domain.CustomerDTO;

import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProcessService {

	
@Autowired RuntimeService runtimeService;
	
	@Autowired private TaskService taskService;
	
	@Autowired private RepositoryService  repositoryService;
	
	
	ProcessInstance processInstance;
	
	public String startTheProcess(String assignee, String clientId) {


		Map<String, Object> variables = new HashMap<>();
		variables.put("assignee", assignee);
		variables.put("clientId",clientId);
        
		processInstance = runtimeService.startProcessInstanceByKey("telkom-process", variables);

		return processInformation();
	}

	// fetching process and task information
	public String processInformation() {

		List<Task> taskList = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();

		StringBuilder processAndTaskInfo = new StringBuilder();
		
		processAndTaskInfo.append("Number of process definition available: "
				+ repositoryService.createProcessDefinitionQuery().count() + " | Task Details= ");

		taskList.forEach(task -> {

			processAndTaskInfo.append("ID: " + task.getId()+ ", Name: " + task.getName());
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
		
		public CustomerDTO createrCust(CustomerDTO cust) {
			String executionId = processInstance.getId();
			
			Task usertasks = taskService.createTaskQuery()
					.processInstanceId(executionId)
					.singleResult();
			
			
			this.runtimeService.setVariable(executionId, "customer", cust);
			
			taskService.complete(usertasks.getId());
			System.out.println(" complete data");
			
			return cust;
		}
}
