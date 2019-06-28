package cn.innotree.activiti.controller;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivitiController {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private IdentityService identityService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private HistoryService historyService;

    @RequestMapping("/start")
    public void start() {
        System.out.println("-------start----------");
        ProcessInstance certProcess = runtimeService.startProcessInstanceByKey("certProcess");
        System.out.println("start:" + certProcess.getId() + "," + certProcess.getName());
    }

    @RequestMapping("/review/{taskId}")
    public void review(@PathVariable String taskId) {
        System.out.println("-------review----------");
        taskService.complete(taskId);
    }

    @RequestMapping("/list/user/{userId}")
    public void findTasksByUserId(@PathVariable String userId) {
        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("certProcess").taskCandidateOrAssigned(userId).list();
        System.out.println("任务列表："+resultTask);
    }
}
