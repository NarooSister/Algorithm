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
                // 여는 괄호 시작할 때 tmp *2, *3 해주고 괄호 push
                case '(':
                    stack.push(c);
                    tmp *= 2;
                    break;

                case '[':
                    stack.push(c);
                    tmp *= 3;
                    break;
                    
                // 1. 닫는 괄호 나왔을 때 불가능한 상황
                // 즉, stack이 비어있거나 최근 괄호가 여는 괄호가 아니라면
                // success = false;
                //
                // 2. 불가능한 상황이 아니라면
                // 2-1. 만약에 그 이전 괄호도 '(' 라면. -> '('가 두겹
                // count에 tmp 더해줌
                // 그 뒤에 여는 괄호 한 개 pop, tmp/2 /3
                
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
