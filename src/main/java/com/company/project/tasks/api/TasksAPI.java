package com.company.project.tasks.api;

import com.company.project.tasks.dto.TaskDTO;
import com.company.project.tasks.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksAPI {
    @Autowired
    private TaskFacade taskFacade;

    @PostMapping
    @ResponseBody
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskFacade.create(taskDTO);
    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TaskDTO update(@RequestBody TaskDTO taskDTO,@PathVariable("taskId") Long taskId) {
        return taskFacade.update(taskDTO, taskId);
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getAllTasks() {
        return taskFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId) {
        return taskFacade.deleteById(taskId);
    }
}
