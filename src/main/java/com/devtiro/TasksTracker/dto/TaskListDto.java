package com.devtiro.TasksTracker.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        Integer numberOfTasks,
        Double progress,
        List<TaskDto> tasks
) {
}
