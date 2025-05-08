import java.util.*;

public class QueuesStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        sc.close();

        Stack<Character> st = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for(char c: s.toCharArray()) {
            st.push(c);
            queue.add(c);
        }

        while(!st.isEmpty() && !queue.isEmpty()) {
            if(st.pop()!=queue.poll()) {
                System.out.printf("The word, %s, is not a palindrome.", s);
                return;
            }
        }
        System.out.printf("The word, %s, is a palindrome.", s);
    }
}