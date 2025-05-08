import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> enqueue=new Stack<>();
        Stack<Integer> dequeue=new Stack<>();
        while(n-->0){
            int a=sc.nextInt();
            if(a==1){
                int elem=sc.nextInt();
                enqueue.push(elem);
            }
            else if(a==2){
                if(dequeue.isEmpty()){
                    while(!enqueue.isEmpty()){
                        dequeue.push(enqueue.pop());
                    }
                }
                dequeue.pop();
            }
            else if(a==3){
                if(dequeue.isEmpty()){
                    while(!enqueue.isEmpty()){
                        dequeue.push(enqueue.pop());
                    }
                }
                System.out.println(dequeue.peek());
            }
        }
        sc.close();
    }
}
