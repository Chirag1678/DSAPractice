import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int poisonousPlants(List<Integer> p) {
        int n = p.size();
        int[] days = new int[n];
        Stack<Integer> st = new Stack<>();
        int maxDays = 0;

        for(int i=0;i<n;i++) {
            int day = 0;

            while(!st.isEmpty() && p.get(i)<=p.get(st.peek())) {
                day = Math.max(day, days[st.pop()]);
            }

            if(!st.isEmpty()) {
                days[i] = day+1;
                maxDays = Math.max(maxDays, days[i]);
            }

            st.push(i);
        }

        return maxDays;
    }

}

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
