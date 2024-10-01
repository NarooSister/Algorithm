import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<int[]>> graph;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        int max=0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b,c});
            graph.get(b).add(new int[]{a,c});
            max = Math.max(max, c);
        }
        st = new StringTokenizer(br.readLine());
        int [] fac = new int[2];
        fac[0] = Integer.parseInt(st.nextToken());
        fac[1] = Integer.parseInt(st.nextToken());
        // 공장이 있는 섬으로 가는 길 중
        // 가장 큰 중량으로 이동할 수 있는 길을 찾는다.

        int low = 1;
        int high = max;
        int result = 0;
        while(low<=high){
            int mid = (low + high) /2;
            if(bfs(fac[0], fac[1], mid)){
                result = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        System.out.println(result);
    }
    // mid 중량으로 이동할 수 있는지 확인하는 bfs
    static boolean bfs(int start, int end, int mid){
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[graph.size()];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == end) return true;
            for(int [] next : graph.get(current)){
                int nextIsland = next[0];
                int weight = next[1];
                if(!visited[nextIsland] && weight>=mid){
                    queue.add(nextIsland);
                    visited[nextIsland] = true;
                }
            }
        }
        return false;
    }
}

