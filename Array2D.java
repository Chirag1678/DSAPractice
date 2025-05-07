import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int hourglassSum(List<List<Integer>> arr) {

        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=3; j++) {
                int sumHourglass = 0;
                for(int k=j; k<j+3; k++) {
                    sumHourglass+=arr.get(i).get(k);
                    sumHourglass+=arr.get(i+2).get(k);
                }
                sumHourglass+=arr.get(i+1).get(j+1);
                if(sumHourglass>maxSum) {
                    maxSum = sumHourglass;
                }
            }
        }

        return maxSum;
    }

}

public class Array2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
