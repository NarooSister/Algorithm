
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            //최대 힙이 비어있거나 x가 중간값보다 작거나 같으면, 최대힙에 넣기
            if(left.isEmpty() || x <= left.peek()){
                left.offer(x);
            } else {
                right.offer(x);
            }
            // 두 힙의 크기를 맞춰준다. 오른쪽(최소 힙)은 무조건 작거나 같아야 함.
            // 왼쪽의 크기가 오른쪽+1 보다 클 때, 오른쪽에 왼쪽 값을 옮겨준다.
            if(left.size() > right.size() + 1){
                right.offer(left.poll());
            }   // 오른쪽이 왼쪽보다 커지면 오른쪽 값을 왼쪽으로 보내준다.
            else if(right.size() > left.size()){
                left.offer(right.poll());
            }
            sb.append(left.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
