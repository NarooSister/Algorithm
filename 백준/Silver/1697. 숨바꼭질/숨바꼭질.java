import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-1, 1, 2};
    static boolean[] visited;
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int k = sc.nextInt();
       System.out.println(bfs(n, k));
    }
    static int bfs(int start, int end){
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 0;
        visited = new boolean[100001];
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                if(now == end) return time;

                for (int j = 0; j < 3; j++) {
                    int nx;
                    if(j <2){
                        nx = now + dx[j];
                    }else {
                        nx = now * dx[j];
                    }
                    if(nx>=0 && nx<=100000 && !visited[nx]){
                        visited[nx] =true;
                        queue.add(nx);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}

