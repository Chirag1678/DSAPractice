import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    public static int downToZero(int n) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        dist[n] = 0;
        visited[n] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr==0) return dist[0];

            if(curr-1>=0 && !visited[curr-1]) {
                dist[curr-1] = dist[curr]+1;
                visited[curr-1] = true;
                queue.add(curr-1);
            }

            for(int i=2;i*i<=curr;i++) {
                if(curr%i==0) {
                    int factor2 = curr/i;

                    int max = Math.max(i, factor2);

                    if(!visited[max]) {
                        dist[max] = dist[curr]+1;
                        visited[max] = true;
                        queue.add(max);
                    }
                }
            }
        }
        return dist[0];
    }
}

public class DownToZeroII {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.downToZero(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
