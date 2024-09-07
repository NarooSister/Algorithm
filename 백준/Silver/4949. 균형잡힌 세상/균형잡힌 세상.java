import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : input.toCharArray()) {
                switch (c) {
                    case '(':
                        stack.push('(');
                        break;

                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                        break;

                    case '[':
                        stack.push('[');
                        break;

                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(']');
                        }
                        break;

                }

            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
