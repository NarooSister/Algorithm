import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 탑의 수
        int [] height = new int[n]; // 탑의 높이 배열
        int [] index = new int[n];  // 신호를 수신한 탑의 인덱스
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] =(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> stack = new ArrayDeque<>();  // 현재 탑의 인덱스
        for (int i = 0; i < n; i++) {
            // 탑이 이전 모든 탑보다 커서 수신을 받을 수 없다면 제거
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                stack.pop();
            }
            // 스택이 비어있지 않다면 수신한 탑이 있음.
            if(!stack.isEmpty()){
                index[i] = stack.peek() + 1;
            } else{ // 비어있다면 수신한 탑이 없음.
                index[i] = 0;
            }
            // 스택에 현재 탑의 인덱스 추가
            stack.push(i);
        }
        // 출력
        for (int i : index) {
            System.out.print(index[i]+" ");
        }
    }
}
