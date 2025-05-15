import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ResultBalls {
    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] containerSize = new int[n];
        int[] ballSum = new int[n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                containerSize[i]+=container.get(i).get(j);
                ballSum[j]+=container.get(i).get(j);
            }
        }

        Arrays.sort(containerSize);
        Arrays.sort(ballSum);

        for(int i=0;i<n;i++) {
            if(containerSize[i]!=ballSum[i]) {
                return "Impossible";
            }
        }

        return "Possible";
    }

}

public class OrganizingBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = ResultBalls.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
