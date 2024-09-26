import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                queue.offer(x);
            } else { // x가 0일경우 가장 작은 값 출력하고 제거
                if(queue.isEmpty()){
                    bw.write("0\n");
                } else {
                   bw.write(queue.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
