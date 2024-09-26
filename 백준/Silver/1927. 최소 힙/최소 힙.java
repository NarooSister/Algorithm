import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                queue.offer(x);
            }
            if(x == 0){ // x가 0일경우 가장 작은 값 출력하고 제거
                if(queue.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
