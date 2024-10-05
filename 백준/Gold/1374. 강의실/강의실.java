import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] time = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, Comparator.comparingInt(a -> a[0]));  //시작시간 기준으로 정렬

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(time[0][1]);
        for (int i = 1; i < n; i++) {
            if(queue.peek() <= time[i][0]){ // 큐에 있는 마지막 종료시간 <= 강의 시작 시간
                queue.poll();   // 강의실을 쓸 수 있으므로 큐에서 제거
            }
            queue.offer(time[i][1]);    // 새 강의실 필요하므로 queue에 넣기
        }
        System.out.println(queue.size());
    }
}
