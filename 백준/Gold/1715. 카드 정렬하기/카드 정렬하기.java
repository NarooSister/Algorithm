import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            result += sum;
            queue.offer(sum);
        }
        System.out.println(result);
    }
}