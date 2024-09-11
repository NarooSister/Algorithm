import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String[]> busTimes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] time = br.readLine().split(" ");
            String inTime = time[0];
            String outTime = time[1];
            busTimes.add(new String[]{inTime, outTime});
        }

        Collections.sort(busTimes, Comparator.comparing(a->a[0]));

        PriorityQueue<String> pq = new PriorityQueue<>();

        int maxBuses = 0;
        for (String[] bus : busTimes) {
            String inTime = bus[0];
            String outTime = bus[1];

            while(!pq.isEmpty() &&  pq.peek().compareTo(inTime) <= 0) {
                pq.poll(); // 나가는 시간에 맞춰 버스를 큐에서 제거
            }
            pq.offer(outTime);
            maxBuses = Math.max(maxBuses, pq.size());
        }
        System.out.println(maxBuses);

    }
}
