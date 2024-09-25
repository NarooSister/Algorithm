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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < n; i++) {
            queue.offer(i+1);
        }
        int index = 0;

        while (!queue.isEmpty()){
            int count = 0;
            index = (index+k-1) % queue.size();

            for(int i : queue){
                if(count == index){
                    sb.append(i).append(", ");
                    queue.remove(i);
                    break;
                }
                count++;
            }
        }
        sb.delete(sb.length()-2, sb.length()).append(">");
        System.out.println(sb);
    }

}
