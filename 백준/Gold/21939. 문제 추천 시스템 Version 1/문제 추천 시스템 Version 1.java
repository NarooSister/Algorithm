import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> problems = new HashMap<>();
        PriorityQueue<int[]> easy = new PriorityQueue<>((a, b) ->
                a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<int[]> hard = new PriorityQueue<>((a, b) ->
                a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] problem = br.readLine().split(" ");
            int num = Integer.parseInt(problem[0]);     // 문제 번호
            int level = Integer.parseInt(problem[1]);   // 난이도
            problems.put(num, level);
            easy.offer(new int[]{num, level});
            hard.offer(new int[]{num, level});
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "recommend" :
                    int x = Integer.parseInt(command[1]);
                    if(x == 1){
                        while(!hard.isEmpty() && (!problems.containsKey(hard.peek()[0]) || problems.get(hard.peek()[0]) != hard.peek()[1])){
                            hard.poll();
                        }
                        if (!hard.isEmpty()) {
                            System.out.println(hard.peek()[0]); // 가장 어려운 문제 번호 출력
                        }
                    } else {
                        while (!easy.isEmpty() && (!problems.containsKey(easy.peek()[0]) || problems.get(easy.peek()[0]) != easy.peek()[1])){
                            easy.poll();
                        }
                        if (!easy.isEmpty()) {
                            System.out.println(easy.peek()[0]); // 가장 쉬운 문제 번호 출력
                        }
                    }
                    break;

                case "add" :
                    int num = Integer.parseInt(command[1]);
                    int level = Integer.parseInt(command[2]);
                    problems.put(num, level);
                    easy.offer(new int[]{num, level});
                    hard.offer(new int[]{num, level});
                    break;

                case "solved" :
                    int remove = Integer.parseInt(command[1]);
                    problems.remove(remove);
                    break;
            }
        }
    }
}
