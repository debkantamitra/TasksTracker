package com.devtiro.TasksTracker.mapper;

import com.devtiro.TasksTracker.dto.TaskDto;
import com.devtiro.TasksTracker.entity.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
