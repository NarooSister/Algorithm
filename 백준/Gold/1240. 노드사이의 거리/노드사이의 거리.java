import java.io.*;
import java.util.*;


/*
1. 입력
노드의 개수 N, 거리를 알고싶은 노드쌍의 개수 M
... n-1개의 줄
트리 상에 연결된 두 점, 거리
... m개의 노드 쌍
노드 쌍

2. 출력
두 노드 사이의 거리 출력

3. 문제 접근법

 */
public class Main {
    static List<List<int[]>> graph;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
           graph.get(a).add(new int[]{b, dist});
           graph.get(b).add(new int[]{a, dist});
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(bfs(a,b) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int a, int b){
        Queue<int[]> queue = new ArrayDeque<>();
        distance = new int[graph.size()];
        visited = new boolean[graph.size()];

        distance[a] = 1;
        visited[a] = true;
        queue.add(new int[]{a,0});

        while (!queue.isEmpty()){
            int [] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            if(node == b){
                return distance;    // 노드가 끝 노드일 때 거리 반환
            }

            for (int [] next  : graph.get(node)) {
                int nextNode = next[0];
                int nextDist = next[1];
                if(!visited[nextNode]){
                visited[nextNode] = true;
                queue.add(new int[]{nextNode, distance + nextDist});
            }
            }
        }
            return -1;
    }
}

