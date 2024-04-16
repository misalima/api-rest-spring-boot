package com.company.project.tasks.facade;

import com.company.project.tasks.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskFacade {
    private static final Map<Long, TaskDTO> tasks = new HashMap<Long, TaskDTO>();

    public TaskDTO create(TaskDTO taskDTO) {
        Long nextId = tasks.keySet().size() + 1L;
        taskDTO.setId(nextId);
        tasks.put(nextId, taskDTO);
        return taskDTO;
    }

    public TaskDTO update(TaskDTO taskDTO, Long id) {
        tasks.put(id, taskDTO);
        return taskDTO;
    }

    public TaskDTO getById(Long id) {
        return tasks.get(id);
    }

    public List<TaskDTO> getAll() {
        return new ArrayList<TaskDTO>(tasks.values());
    }

    public String deleteById(Long id) {
        tasks.remove(id);
        return "Task deleted";
    }
}
