package com.devtiro.TasksTracker.mapper.impl;

import com.devtiro.TasksTracker.dto.TaskListDto;
import com.devtiro.TasksTracker.entity.TaskList;
import com.devtiro.TasksTracker.entity.enums.TaskStatus;
import com.devtiro.TasksTracker.mapper.TaskListMapper;
import com.devtiro.TasksTracker.mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskListMapperImpl implements TaskListMapper {
    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return TaskList.builder()
                .id(taskListDto.id())
                .title(taskListDto.title())
                .description(taskListDto.description())
                .tasks(
                        Optional.ofNullable(taskListDto.tasks())
                                .map(tasks -> tasks.
                                        stream()
                                        .map(taskMapper::fromDto)
                                        .toList())
                                .orElse(null)
                )
                .build();
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                taskList.getTasks().size(),
                (double)taskList.getTasks().stream().filter(task -> task.getStatus().equals(TaskStatus.CLOSE)).count()/taskList.getTasks().size(),
                taskList.getTasks().stream().map(taskMapper::toDto).collect(Collectors.toList())
        );
    }
}
