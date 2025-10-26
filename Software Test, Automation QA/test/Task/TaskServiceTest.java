package test.task;

import main.task.Task;
import main.task.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    void setUp() {
        service = new TaskService();
    }

    @Test
    void testAddTaskUniqueId() {
        Task task1 = new Task("1", "Marco", "Initial description");
        service.addTask(task1);

        assertEquals("Marco", task1.getName());
        assertEquals("Initial description", task1.getDescription());

        // Adding another task with the same ID should throw exception
        Task task2 = new Task("1", "Anna", "Another description");
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    @Test
    void testUpdateTaskName() {
        Task task = new Task("2", "Marco", "This is the new description.");
        service.addTask(task);

        service.updateTaskName("2", "NewName");
        assertEquals("NewName", task.getName());

        // Updating non-existent task should throw exception
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("999", "Name"));
    }

    @Test
    void testUpdateTaskDescription() {
        Task task = new Task("3", "Anna", "Initial description");
        service.addTask(task);

        service.updateTaskDescription("3", "NewDescription");
        assertEquals("NewDescription", task.getDescription());

        // Updating non-existent task should throw exception
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("999", "Desc"));
    }

    @Test
    void testDeleteTask() {
        Task task = new Task("4", "Marco", "Desc");
        service.addTask(task);

        service.deleteTask("4");
        // Deleting a task should remove it, subsequent update should fail
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("4", "Name"));
    }

    @Test
    void testTaskConstraints() {
        // Task ID > 10 characters
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Desc"));

        // Name > 20 characters
        assertThrows(IllegalArgumentException.class, () -> new Task("5", "NameNameNameNameNameName", "Desc"));

        // Description > 50 characters
        assertThrows(IllegalArgumentException.class, () -> new Task("6", "Name", "D".repeat(51)));
    }
}
