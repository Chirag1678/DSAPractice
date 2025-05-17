import java.util.Arrays;

public class AttendMeetings {
    public static void main(String[] args) {
        int[][] intervals = {{0, 4}, {5, 17}, {15, 20}};
        System.out.println(canAttendMeetings(intervals)); // Output: false

        int[][] intervals2 = {{7, 10}, {2, 4}};
        System.out.println(canAttendMeetings(intervals2)); // Output: true
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
