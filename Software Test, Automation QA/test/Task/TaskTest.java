package test.task;

import static org.junit.jupiter.api.Assertions.*;

import main.task.Task;
import org.junit.jupiter.api.Test;

public class TaskTest {

    // Task ID tests
    @Test
    public void testValidTaskId() {
        Task task = new Task("999", "Miguel", "This is a description.");
        assertEquals("999", task.getTaskId());
    }

    @Test
    public void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("9999999999999999", "Miguel", "This is a description.");
        });
    }

    @Test
    public void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Miguel", "This is a description.");
        });
    }

    // Name tests
    @Test
    public void testValidName() {
        Task task = new Task("999", "ValidName", "Description");
        assertEquals("ValidName", task.getName());
    }

    @Test
    public void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("999", "ThisNameIsWayTooLongForTheLimit", "Description");
        });
    }
}
