import java.util.*;

public class JavaHashSet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> set = new HashSet<>();

        long n = sc.nextLong();
        sc.nextLine();

        for(long i=0; i<n; i++) {
            String s = sc.nextLine();
            set.add(s);
            System.out.println(set.size());
        }
        sc.close();
    }
}
