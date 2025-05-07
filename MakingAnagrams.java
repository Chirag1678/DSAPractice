import java.io.*;
import java.util.*;

class ResultAnagrams {
    public static int makingAnagrams(String s1, String s2) {
        ArrayList<Character> s1Chars = new ArrayList<>();
        ArrayList<Character> s2Chars = new ArrayList<>();

        for(char c: s1.toCharArray()) {
            s1Chars.add(c);
        }
        for(char c:s2.toCharArray()) {
            s2Chars.add(c);
        }

        for(int i=0;i<s1Chars.size();i++) {
            char c = s1Chars.get(i);
            if(s2Chars.contains(c)) {
                s1Chars.remove(i);
                s2Chars.remove((Character)c);
                i--;
            }
        }

        return s1Chars.size() + s2Chars.size();
    }

}

public class MakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = ResultAnagrams.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
