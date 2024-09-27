import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<int[]>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st. nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 그래프 양쪽에 간선 추가
            graph[a].add(new int[]{b,cost});
            graph[b].add(new int[]{a,cost});
        }
        System.out.println(prim());
    }
    static int prim(){
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int totalCost = 0;

        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int index = current[0];
            int cost = current[1];

            if(visited[index]) continue;

            visited[index] = true;
            totalCost += cost;

            for(int[] edge : graph[index]){
                if(!visited[edge[0]]){
                    queue.offer(new int[]{edge[0], edge[1]});
                }
            }
        }
        return totalCost;
    }
}

