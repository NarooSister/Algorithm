import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 거인 인구 수
        int h = Integer.parseInt(st.nextToken());   // 센티의 키
        int t = Integer.parseInt(st.nextToken());   // 횟수 제한

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);   // 우선순위 큐 최대힙
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int giantH = Integer.parseInt(st.nextToken());  // 각 거인의 키
            queue.offer(giantH);
        }
        
        int count = 0;
        while(count<t) {
            int maxGiant = queue.peek();
            if (maxGiant < h) {    // 모든 거인이 센티보다 작을 때
                System.out.println("YES");
                System.out.println(count);
                return; // 즉시 종료
            }
            if(maxGiant == 1) break;    // 1인 경우 생략
            // 거인 뿅망치 적용
            queue.poll();
            queue.offer(maxGiant/2);
            count++;
        }

        if(queue.peek() >= h){
            System.out.println("NO");
            System.out.println(queue.peek());
        } else{
            System.out.println("YES");
            System.out.println(count);
        }
    }
}
