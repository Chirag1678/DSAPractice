import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static long largestRectangle(List<Integer> h) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        st.push(0);
        int i;
        for(i=1;i<h.size();i++){
            while(!st.isEmpty() && h.get(i)<h.get(st.peek())){
                maxArea=getMaxArea(h,st,maxArea,i);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            maxArea=getMaxArea(h, st, maxArea, i);
        }
        return maxArea;
    }

    private static int getMaxArea(List<Integer> h,Stack<Integer> st,int maxArea,int i){
        int area;
        int popped=st.pop();
        if(st.isEmpty()){
            area=h.get(popped)*i;
        }
        else{
            area=h.get(popped)*(i-st.peek()-1);
        }
        return Math.max(maxArea,area);
    }
}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
