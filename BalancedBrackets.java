import java.io.*;
import java.util.*;
import java.util.stream.*;

class ResultParentheses {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='{' || ch=='[' || ch=='('){
                st.push(ch);
            }
            else {
                if (st.isEmpty()) return "NO";
                char top = st.peek();
                if ((ch == '}' && top == '{') ||
                        (ch == ']' && top == '[') ||
                        (ch == ')' && top == '(')) {
                    st.pop();
                } else {
                    return "NO";
                }
            }
        }
        return st.isEmpty()?"YES":"NO";
    }
}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = ResultParentheses.isBalanced(s);

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
