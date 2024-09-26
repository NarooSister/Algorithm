import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            if(a!=0){   // 0이 아닌 경우 a개의 선물 충전
                for (int j = 0; j <a; j++) {
                    int gift = Integer.parseInt(st.nextToken());
                    queue.offer(gift);
                }
            } else{ // a가 0인 경우 선물의 가치 출력
                if(queue.isEmpty()){
                    bw.write("-1\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
