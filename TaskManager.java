import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer, int[]> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });
        taskMap = new HashMap<>();

        for(List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            int[] entry = new int[] {priority, taskId, userId};
            pq.offer(entry);
            taskMap.put(taskId, entry);
        }
    }

    public void add(int userId, int taskId, int priority) {
        int[] entry = new int[] {priority, taskId, userId};
        pq.offer(entry);
        taskMap.put(taskId, entry);
    }

    public void edit(int taskId, int newPriority) {
        if(!taskMap.containsKey(taskId)) return;

        int userId = taskMap.get(taskId)[2];
        int[] newEntry = new int[] {newPriority, taskId, userId};

        pq.offer(newEntry);
        taskMap.put(taskId, newEntry);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int priority = top[0], taskId = top[1], userId = top[2];

            if(taskMap.containsKey(taskId) && taskMap.get(taskId) == top) {
                taskMap.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}
