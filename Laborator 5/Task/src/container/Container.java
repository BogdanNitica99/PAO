package container;

import task.Task;

public interface Container {

    void addTask(Task task);

    void removeTask();

    boolean hasTask();

    void runTask();
}
