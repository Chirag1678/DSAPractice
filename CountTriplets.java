import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> frequencyMap = new HashMap<>();
        Map<Long, Long> pairMap = new HashMap<>();

        for(Long val:arr) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0L)+1);
        }

        long pairs = 0;
        for(Long mid:arr) {
            frequencyMap.put(mid, frequencyMap.get(mid)-1);

            if(mid%r==0) {
                long left = mid/r;
                long right = mid*r;

                long leftPairs = pairMap.getOrDefault(left, 0L);
                long rightPairs = frequencyMap.getOrDefault(right, 0L);

                pairs+= leftPairs * rightPairs;
            }

            pairMap.put(mid, pairMap.getOrDefault(mid, 0L)+1);
        }
        return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
