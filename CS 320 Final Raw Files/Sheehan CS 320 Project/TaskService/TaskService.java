
import java.util.HashMap;
import java.util.Map;

public class TaskService {

    //hashmap for fastlookup of ID
    private final Map<String, Task> tasks = new HashMap<>();


    
    public void addTask(String taskId, String name, String description) {
        // add task with validation for uniqueness
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID already exists");
        }

        tasks.put(taskId, new Task(taskId, name, description));
    }

    public void deleteTask(String taskId) {
        //delete task by ID

        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        tasks.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        //update name with validation

        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        task.setName(newName);
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        // update description with validation

        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("task ID does not exist");
        }
        task.setDescription(newDescription);
    }

    //retrieve a task by ID
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
