import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);   // 우선순위 큐 최대힙
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int giantH = Integer.parseInt(st.nextToken());
            queue.offer(giantH);
        }
        
        int count = 0;
        while(count<t) {
            int maxGiant = queue.peek();
            if (maxGiant < h) {
                System.out.println(sb.append("YES").append("\n").append(count));
                return;
            }
            
            if(maxGiant == 1) break;
            queue.poll();
            queue.offer(maxGiant/2);
            count++;
        }
        
        if(queue.peek() >= h){
            System.out.println(sb.append("NO").append("\n").append(queue.peek()));
        } else{
            System.out.println(sb.append("YES").append("\n").append(count));
        }
    }
}
