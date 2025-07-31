package com.devtiro.TasksTracker.mapper.impl;

import com.devtiro.TasksTracker.dto.TaskDto;
import com.devtiro.TasksTracker.entity.Task;
import com.devtiro.TasksTracker.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(TaskDto taskDto) {
        return Task.builder()
                .id(taskDto.id())
                .title(taskDto.title())
                .description(taskDto.description())
                .priority(taskDto.priority())
                .status(taskDto.status())
                .build();
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
