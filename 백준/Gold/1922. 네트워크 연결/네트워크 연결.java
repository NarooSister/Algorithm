import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


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

            // 무방향이므로 그래프 양쪽에 간선 추가
            graph[a].add(new int[]{b,cost});
            graph[b].add(new int[]{a,cost});
        }
        System.out.println(prim());
    }
    static int prim(){
        boolean[] visited = new boolean[n+1];   // 방문했던 정점
        // 최소 가중치 노드가 먼저 나오도록 함
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int totalCost = 0;  // 총 최소가중치의 합 = 최소비용

        queue.offer(new int[]{1,0});   // 시작
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int index = current[0]; // 정점
            int cost = current[1];  // 가중치

            if(visited[index]) continue;    // 방문 했던 곳이면 넘기기

            visited[index] = true;
            totalCost += cost;  // 가중치 더해주기
            
            // 현재 정점에서 갈 수 있는 다른 정점으로의 간선 추가
            // 그래프[index]로 돌리면서 간선 추가
            for(int[] edge : graph[index]){
                if(!visited[edge[0]]){
                    queue.offer(new int[]{edge[0], edge[1]});
                }
            }
        }
        return totalCost;
    }
}

