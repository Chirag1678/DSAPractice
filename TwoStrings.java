import java.io.*;
import java.util.*;
import java.util.stream.*;
class ResultStrings {
    public static String twoStrings(String s1, String s2) {
        HashSet<Character> s1Chars = new HashSet<>();

        for(char c:s1.toCharArray()) {
            s1Chars.add(c);
        }

        for(char c:s2.toCharArray()) {
            if(s1Chars.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = ResultStrings.twoStrings(s1, s2);

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
