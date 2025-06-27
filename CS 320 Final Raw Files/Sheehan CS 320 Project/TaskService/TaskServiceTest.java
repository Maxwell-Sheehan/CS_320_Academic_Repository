
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTaskSuccessfully() {
        // add a valid task and assert it's stored

        taskService.addTask("1", "Test", "Description");
        Task task = taskService.getTask("1");
        assertEquals("Test", task.getName());
    }

    @Test
    public void testAddTaskDuplicateId() {
        // Add two tasks with same ID and expect exception or error
        taskService.addTask("1", "Test", "Desc");
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask("1", "Another", "Another Desc");
        });

    }

    @Test
    public void testDeleteTask() {
        //Add then delete task, assert it's gone

        taskService.addTask("1", "Test", "Desc");
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        //add task, update name, assert change

        taskService.addTask("1", "Test", "Desc");
        taskService.updateTaskName("1", "Updated");
        assertEquals("Updated", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        //add task, update description, assert change

        taskService.addTask("1", "Test", "Desc");
        taskService.updateTaskDescription("1", "Updated Desc");
        assertEquals("Updated Desc", taskService.getTask("1").getDescription());
    }

    @Test
    public void testUpdateNoneexistentTask() {
        //Attempt to update a task that doesn't exist

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("999", "Name");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("999", "Desc");
        });
    }
}
