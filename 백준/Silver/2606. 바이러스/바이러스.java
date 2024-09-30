import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
1. 입력
컴퓨터의 수 n
직접 연결되어 있는 컴퓨터 쌍의 수 m
... m줄 동안
연결되어 있는 컴퓨터 번호 쌍

2. 출력
1번 컴퓨터가 바이러스 걸렸을 때,
1번 컴퓨터를 통해 바이러스에 걸리게 되는 컴퓨터의 수

3. 문제 접근법
1번 컴퓨터와 연결된 모든 컴퓨터의 수를 구하면 된다.
양방향 간선으로 추가해야 한다.
DFS 사용.

 */
public class Main {
    static List<List<Integer>> graph;
    static boolean [] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);    // a에서 b 간선 추가
            graph.get(b).add(a);    // b에서 a 방향 추가
        }

        visited = new boolean[n+1];
        dfs(1);
        System.out.println(count-1);
    }

    static void dfs(int current) {
        visited[current] = true;
        count++;
        for(int next: graph.get(current)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}

