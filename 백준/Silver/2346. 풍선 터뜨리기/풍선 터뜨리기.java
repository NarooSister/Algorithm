import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 원형 큐라고 생각하고 구현
    // index가 큐의 사이즈를 넘어가면 나머지 연산으로 다시 구해줌
    // index = (index+k-1) % queue.size();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();    // 풍선 번호, 이동값 저장
        for (int i = 0; i < n; i++) {
            deque.offer(new int[]{i+1, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int [] current = deque.poll();
        sb.append(current[0]).append(" ");

        while(!deque.isEmpty()) {
            int move = current[1];
            if (move > 0) {
                for (int i = 0; i < move-1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
            current = deque.poll();
            sb.append(current[0]).append(" ");
        }
        System.out.println(sb);
    }

}
