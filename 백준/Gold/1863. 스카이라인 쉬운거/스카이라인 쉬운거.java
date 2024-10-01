import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        // 스택에 넣으면서 이전 y보다 지금 y가 작으면 터뜨린다.
        // 더 크면 스택에 넣는다.
        // 반복하고 마지막 남은 건물 처리한다.
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek()>y){
                stack.pop();
                count++;
            }
            if(stack.isEmpty() || stack.peek()<y){
                stack.push(y);
            }
        }
        while(!stack.isEmpty() && stack.peek()>0){
            stack.pop();
            count++;
        }
        System.out.println(count);
    }
}

