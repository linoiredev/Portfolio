package main.task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    // Add a task with unique ID
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }

    // Delete task by ID
    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    // Update task name by ID
    public void updateTaskName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found.");
        }
        task.setName(newName);
    }

    // Update task description by ID
    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found.");
        }
        task.setDescription(newDescription);
    }

}