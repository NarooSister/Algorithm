import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int current = 1;
        int idx = 0;
        while(idx < n || !stack.isEmpty()){
            if (idx < n && arr[idx] == current){
                idx++;
                current++;
            } else if(!stack.isEmpty() && stack.peek() == current){
                stack.pop();
                current++;
            } else if(idx < n){
                stack.push(arr[idx]);
                idx++;
            } else{
                System.out.println("Sad");
                return;
            }
        
        }
        System.out.println("Nice");
    }
}
