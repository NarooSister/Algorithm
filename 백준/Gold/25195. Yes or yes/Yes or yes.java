import java.io.*;
import java.util.*;


/*
1. 입력
정점의 개수 n, 간선의 개수 m
... m줄 동안
정점 u, 정점 v 로 가는 간선이 있음
...
팬클럽 곰곰이가 존재하는 정점의 개수 s
팬클럽 곰곰이가 존재하는 정점의 번호 s개

2. 출력
팬클럽 곰곰이를 만나면 Yes, 아닌 방법이 존재하면 yes 출력

3. 문제 접근법
dfs로 진행하면서 팬을 만나지 않는지 확인
더이상 남은 간선이 없다면 YES.

 */
public class Main {
    static List<List<Integer>> graph;
    static Set<Integer> fans = new HashSet<>(); // 팬이 있는 정점
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }
        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            fans.add(Integer.parseInt(st.nextToken()));
        }
        dfs(1);
        System.out.println(check ? "yes" : "Yes");


    }
  static void dfs(int current){
        // 팬이 있는 곳을 지나간 경우
        if(check || fans.contains(current)) return;
        // 가져올 간선이 없다면
        if(graph.get(current).isEmpty()){
            check = true;
            return;
        }
        for(int next : graph.get(current)) dfs(next);
  }
}

