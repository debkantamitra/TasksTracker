package com.devtiro.TasksTracker.mapper;

import com.devtiro.TasksTracker.dto.TaskListDto;
import com.devtiro.TasksTracker.entity.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
