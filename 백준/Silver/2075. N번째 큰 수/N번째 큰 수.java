import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] lineNums = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {

                priorityQueue.offer(Integer.parseInt(lineNums[j]));

                if (priorityQueue.size() > n) {

                    priorityQueue.poll();
                }
            }
        }
        System.out.println(priorityQueue.peek());
    }
}
