import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> primes = generatePrimes(q);
        List<Integer> ans = new ArrayList<>();

        Stack<Integer> current = new Stack<>();
        for(int n:number) {
            current.push(n);
        }

        for(int i=0;i<q;i++) {
            Stack<Integer> next = new Stack<>();
            Stack<Integer> b = new Stack<>();
            int prime = primes.get(i);

            while(!current.isEmpty()) {
                int val = current.pop();
                if(val%prime==0) {
                    b.push(val);
                } else {
                    next.push(val);
                }
            }

            while(!b.isEmpty()) {
                ans.add(b.pop());
            }

            current = next;
        }

        while(!current.isEmpty()) {
            ans.add(current.pop());
        }

        return ans;
    }

    private static List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;

        while(primes.size()<n) {
            if(isPrime(num)) {
                primes.add(num);
            }
            num++;
        }

        return primes;
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;

        for(int i=2;i*i<=n;i++) {
            if(n%i==0) return false;
        }

        return true;
    }

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
