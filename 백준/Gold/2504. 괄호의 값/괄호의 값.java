import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        int tmp = 1;
        boolean success = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    tmp *= 2;
                    break;

                case '[':
                    stack.push(c);
                    tmp *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        success = false;
                        break;
                    }
                    if (input.charAt(i - 1) == '(') {
                        count += tmp;
                    }
                    stack.pop();
                    tmp /= 2;

                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        success = false;
                        break;
                    }
                    if (input.charAt(i - 1) == '[') {
                        count += tmp;
                    }
                    stack.pop();
                    tmp /= 3;

                    break;
            }
        }

        if (!success || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}
