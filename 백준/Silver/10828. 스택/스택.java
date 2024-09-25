import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr;
    private static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
            }
        }
    }

    public static void push(int x) {
        if (top != arr.length - 1) {
            top++;
            arr[top] = x;
        }
    }

    public static int pop() {
        return top != -1 ? arr[top--] : -1;

    }

    public static int size() {
        return top + 1;
    }

    public static int empty() {
       return top == -1 ? 1 : 0;
    }

    public static int top() {
        return top == -1 ? -1 : arr[top];
    }

}
