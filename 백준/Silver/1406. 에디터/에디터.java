import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    // 커서의 왼쪽과 오른쪽을 분리하여 Deque에 넣어 관리한다.
    // L의 경우 왼쪽 deque 끝 문자를 오른쪽 deque 맨 앞에 넣어주면 됌.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            left.addLast(c);
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "L":
                    if (!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;

                case "D":
                    if (!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;

                case "B":
                    if (!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;

                case "P":
                    left.addLast(order[1].charAt(0));
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.append(c);
        }
        for (char c : right) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
