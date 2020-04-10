package container;

import task.Task;

import java.util.LinkedList;

public class Stack implements Container {

    private LinkedList<Task> taskList = new LinkedList<>();

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public void removeTask() {
        taskList.removeLast();
    }

    @Override
    public boolean hasTask() {
        return !taskList.isEmpty();
    }

    @Override
    public void runTask() {
        Task task = taskList.getLast();
        removeTask();
        task.run();
    }
}
