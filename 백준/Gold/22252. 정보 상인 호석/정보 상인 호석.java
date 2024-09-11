import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> gorilla = new HashMap<>();

        long result = 0;

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split(" ");
            int num = Integer.parseInt(strings[0]);

            switch (num) {
                case 1:
                    String name = strings[1];
                    int k = Integer.parseInt(strings[2]);

                    gorilla.putIfAbsent(name, new PriorityQueue<>(Collections.reverseOrder()));
                    PriorityQueue<Integer> infoQueue = gorilla.get(name);

                    for (int j = 3; j < 3 + k; j++) {
                        infoQueue.offer(Integer.parseInt(strings[j]));
                    }

                    break;

                case 2:
                    name = strings[1];
                    int b = Integer.parseInt(strings[2]);
                    // 고릴라의 정보 큐를 가져옴
                    PriorityQueue<Integer> infoQueue2 = gorilla.get(name);  // get()을 사용하여 없는 경우 처리
                    if (infoQueue2 != null) {  // 고릴라가 존재하는 경우에만 처리
                        for (int j = 0; j < b && !infoQueue2.isEmpty(); j++) {
                            result += infoQueue2.poll();  // 최댓값을 구매하고 result에 더함
                        }
                    }
                    break;
            }
        }
        System.out.println(result);
    }
}
