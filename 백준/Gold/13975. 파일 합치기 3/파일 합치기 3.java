import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            String [] input = br.readLine().split(" ");

            PriorityQueue<Long> queue = new PriorityQueue<>();
            for (int j = 0; j < k; j++) {
                queue.offer(Long.parseLong(input[j]));
            }
            long count = 0;

            while (queue.size() > 1) {
                long a = queue.poll();
                long b = queue.poll();
                long sum = a + b;
                count += sum;
                queue.offer(sum);
            }
            System.out.println(count);
        }
    }
}

