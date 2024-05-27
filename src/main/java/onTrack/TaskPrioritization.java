package onTrack;

import onTrack.models.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskPrioritization {
    private List<Task> tasks = new ArrayList<>();
    private List<Integer> priorities = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        priorities.add(tasks.size() - 1);
    }

    public void prioritizeTask(Task task, int priority) {
        int index = tasks.indexOf(task);
        if (index != -1) {
            priorities.remove(Integer.valueOf(index));
            if (priority >= priorities.size()) {
                priorities.add(index);
            } else {
                priorities.add(priority, index);
            }
        }
    }

    public List<Task> getTasksSortedByPriority() {
        return priorities.stream()
                .map(tasks::get)
                .collect(Collectors.toList());
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void sortTasksByPriority() {
        tasks = getTasksSortedByPriority();
        priorities.clear();
        for (int i = 0; i < tasks.size(); i++) {
            priorities.add(i);
        }
    }
}
