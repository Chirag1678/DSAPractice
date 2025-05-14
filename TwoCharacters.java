import java.io.*;
import java.util.*;

class Result {
    public static int alternate(String s) {
        List<Character> uniqueCharacters = new ArrayList<>();

        for(char c:s.toCharArray()) {
            if(!uniqueCharacters.contains(c)) {
                uniqueCharacters.add(c);
            }
        }

        int maxValidLength = 0;
        for(int i=0;i<uniqueCharacters.size();i++) {
            for(int j=i+1;j<uniqueCharacters.size();j++) {
                int validLength = maxValidLength(s, uniqueCharacters.get(i), uniqueCharacters.get(j));
                maxValidLength = Math.max(maxValidLength, validLength);
            }
        }

        return maxValidLength;
    }

    private static int maxValidLength(String s, char first, char second) {
        char previous='\0';
        int count=0;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c==first || c==second) {
                if(previous==c) return -1;

                previous = s.charAt(i);
                count++;
            }
        }

        return count;

    }

}

public class TwoCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
