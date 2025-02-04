import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] arr;
    private static int top = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "push":
                    push(Integer.parseInt(command[1]));
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "top":
                    sb.append(top()).append("\n");
                    break;

            }
        }
        System.out.println(sb);
    }

    public static void push(int x) {
        if (top != arr.length - 1) {
            top++;
            arr[top] = x;
        }
    }

    public static int pop() {
        if (top == -1) {
            return -1;
        } else {
            return arr[top--];
        }
    }

    public static int size() {
        return top + 1;
    }

    public static int empty() {
        if (top == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (top == -1) {
            return -1;
        } else {
            return arr[top];
        }
    }
}
