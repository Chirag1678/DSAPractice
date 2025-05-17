import java.util.PriorityQueue;

public class AttendMeetings {
    public static void main(String[] args) {
        int[][] intervals = {{0, 4}, {5, 17}, {15, 20}};
        System.out.println(canAttendMeetings(intervals)); // Output: false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals2)); // Output: true
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            pq.offer(interval);
        }
        int[] prev = pq.poll();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] < prev[1]) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
