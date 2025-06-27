
public class Task {

    // unique immutable ID
    private final String taskId;

    //max 20 char, can't be null
    private String name;

    // max 50 char, can't be null
    private String description;

    // constructor with validation
    public Task(String taskId, String name, String description) {

        //validate taskId, must be smaller then 10 char and not null
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("invalid taskId");
        }

        //validate name, must be smaller then 20 char and not null
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("invalid name");
        }

        //validate desc, must be smaller then 50 char and not null
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("invalid description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;

    }

    //getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //setters with validation
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("invalid description");
        }
        this.description = description;
    }
}
