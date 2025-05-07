import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultManipulation {
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        int[] arr = new int[n+2];

        for(int i=0;i<queries.size();i++) {
            int start = queries.get(i).get(0);
            int end = queries.get(i).get(1);
            int add = queries.get(i).get(2);
            arr[start]+=add;
            arr[end+1]-=add;
        }

        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            sum+=arr[i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = ResultManipulation.arrayManipulation(n, queries);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
