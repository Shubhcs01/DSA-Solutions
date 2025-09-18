import java.util.*;

class TaskManager {

    Map<Integer, int[]> mp;
    TreeSet<int[]> st;

    public TaskManager(List<List<Integer>> tasks) {
        mp = new HashMap<>();
        st = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // sort by priority
            return a[1] - b[1];       
        });

        for (List<Integer> task : tasks) {
            int userId = task.get(0), taskId = task.get(1), priority = task.get(2);
            st.add(new int[]{priority, taskId});
            mp.put(taskId, new int[]{userId, priority});
        }
    }

    public void add(int userId, int taskId, int priority) {
        st.add(new int[]{priority, taskId});
        mp.put(taskId, new int[]{userId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int[] p = mp.get(taskId);
        st.remove(new int[]{p[1], taskId});
        st.add(new int[]{newPriority, taskId});
        mp.put(taskId, new int[]{p[0], newPriority});
    }

    public void rmv(int taskId) {
        int[] p = mp.get(taskId);
        st.remove(new int[]{p[1], taskId});
        mp.remove(taskId);
    }

    public int execTop() {
        if (mp.isEmpty()) return -1;
        int[] top = st.last();
        int taskId = top[1];
        int userId = mp.get(taskId)[0];
        st.remove(top);
        mp.remove(taskId);
        return userId;
    }
}