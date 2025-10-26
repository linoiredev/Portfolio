package main.task;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    // Constructor enforces requirements
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be empty and must be ≤ 10 characters.");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name cannot be empty and must be ≤ 20 characters.");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description cannot be empty and must be ≤ 50 characters.");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId; // ID is unchangeable
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name cannot be empty and must be ≤ 20 characters.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description cannot be empty and must be ≤ 50 characters.");
        }
        this.description = description;
    }

}

