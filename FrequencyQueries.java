import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for(List<Integer> query: queries) {
            int type = query.get(0);
            int value = query.get(1);
            switch(type) {
                case 1:
                    int oldFreq = frequencyMap.getOrDefault(value, 0);
                    int newFreq = oldFreq+1;
                    frequencyMap.put(value, newFreq);

                    frequencyCount.put(oldFreq, frequencyCount.getOrDefault(oldFreq, 0)-1);
                    frequencyCount.put(newFreq, frequencyCount.getOrDefault(newFreq, 0)+1);
                    break;

                case 2:
                    if(frequencyMap.containsKey(value)) {
                        oldFreq = frequencyMap.get(value);
                        newFreq = oldFreq - 1;

                        frequencyCount.put(oldFreq, frequencyCount.getOrDefault(oldFreq,0)-1);

                        if(newFreq>0) {
                            frequencyMap.put(value, newFreq);
                            frequencyCount.put(newFreq, frequencyCount.getOrDefault(newFreq,0)+1);
                        } else {
                            frequencyMap.remove(value);
                        }
                    }
                    break;

                case 3:
                    result.add(frequencyCount.getOrDefault(value, 0)>0?1:0);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
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

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
