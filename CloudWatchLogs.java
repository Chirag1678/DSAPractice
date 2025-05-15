import java.util.*;

public class CloudWatchLogs {
    public static void main(String[] args) {
        List<List<String>> logs = Arrays.asList(
                Arrays.asList("01-01-2022", "14:00", "CRITICAL", "failed"),
                Arrays.asList("01-01-2023", "15:00", "INFO", "established"),
                Arrays.asList("01-01-2023", "15:00", "ERROR", "failed")
        );

        List<List<String>> result = new CloudWatchLogs().extractErrorLogs(logs);

        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<String>> extractErrorLogs(List<List<String>> logs) {
        List<List<String>> filteredLogs = new ArrayList<>();

        for (List<String> log : logs) {
            String logType = log.get(2);

            if (logType.equals("ERROR") || logType.equals("CRITICAL")) {
                filteredLogs.add(log);
            }
        }

        filteredLogs.sort((a, b) -> {
            String dateTimeA = a.get(0) + " " + a.get(1);
            String dateTimeB = b.get(0) + " " + b.get(1);
            return dateTimeA.compareTo(dateTimeB);
        });

        return filteredLogs;
    }
}
