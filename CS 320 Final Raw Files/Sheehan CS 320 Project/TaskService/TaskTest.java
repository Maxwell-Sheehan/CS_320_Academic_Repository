
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreationValidData() {
        //create a task with a valid Id, name and description
        // assert all fields are set correctly

        Task task = new Task("123", "Name", "Description");
        assertEquals("123", task.getTaskId());
        assertEquals("Name", task.getName());
        assertEquals("Description", task.getDescription());
    }

    @Test
    public void testTaskIdNotUpdatable() {
        // create a task and verify taskId cannot be changed(it's final)
        Task task = new Task("123", "Name", "Desc");
        assertEquals("123", task.getTaskId());

    }

    @Test
    public void testTaskIdTooLong() {
        //attempt to create a task with taskId > 10 char

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "name", "desc");
        });
    }

    @Test
    public void testNullTaskId() {
        // attempt to create a task with null taskId

        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "name", "Desc");
        });
    }

    @Test
    public void testInvalidNameTooLong() {
        //attempt to create a task with name > 20 char

        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "ThisNameIsWayTooLong12345", "Desc");
        });

    }

    @Test
    public void testInvalidDescriptionTooLong() {
        // attempt to create a task with description > 50 char
        //expect exception or failure
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Name", "This description is far too long to be accepted by the system at this stage.");
        });
    }

    @Test
    public void testSetNameValid() {
        //update the name and assert the change
        Task task = new Task("123", "Name", "Desc");
        task.setName("NewName");
        assertEquals("NewName", task.getName());
    }

    @Test
    public void testSetDescriptionValid() {
        //update the description and assert the change
        Task task = new Task("123", "Name", "Desc");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    public void testSetNameNull() {
        //attempt to set name to null
        //expect exception

        Task task = new Task("123", "Name", "Desc");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    public void testSetDescriptionNull() {
        // attempt to set description to null
        // expect exception

        Task task = new Task("123", "Name", "Desc");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }
}
