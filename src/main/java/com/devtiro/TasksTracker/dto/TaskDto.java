package com.devtiro.TasksTracker.dto;

import com.devtiro.TasksTracker.entity.enums.TaskPriority;
import com.devtiro.TasksTracker.entity.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(UUID id,
                      String title,
                      String description,
                      LocalDateTime dueDate,
                      TaskPriority priority,
                      TaskStatus status
) {
}
