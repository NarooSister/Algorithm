import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Stack에 단어를 집어넣는다.
// 같은 단어가 연속되면 두 개를 같이 없앤다.
// 없앤 뒤 나머지 단어를 넣는다. 마찬가지로 같은 단어가 중복되면 같이 없앤다.
// 반복했을 때 stack이 비면 좋은 단어!

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        int count = 0;  // 좋은 단어의 수
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : words[i].toCharArray()) {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}
