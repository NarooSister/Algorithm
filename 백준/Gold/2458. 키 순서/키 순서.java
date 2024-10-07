import java.io.*;
import java.util.*;
/*
1. 입력
학생들의 수 n, 두 학생 키를 비교한 횟수 m
m개의 줄 동안
... 두 학생의 키를 비교한 결과 a, b (a가 b보다 키가 작음)

2. 출력
자신의 키가 몇 번째인지 알 수 있는 학생이 몇 명인지

3. 풀이
모든 키 결과를 구해야 하므로 플로이드-워셜로 풀었다.
나보다 큰 학생 + 나보다 작은 학생이 n-1인 경우에 키를 정확히 알 수 있다.

	
*/
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] graph = new int[n+1][n+1];
		
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE); // 각 행을 초기화
			graph[i][i] = 0;	// 자기 자신은 0
		}
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;	// a가 b보다 키가 작음
		}
		
		floyd(graph);
		
		int result = 0;	
		for(int i=1;i<=n;i++) {
			int count = 0;
			for(int j=1;j<=n;j++) {
				// 자기보다 크거나 작은 수를 만나면 count++
				if(graph[i][j] != Integer.MAX_VALUE || graph[j][i] !=Integer.MAX_VALUE) {
					count++;
				}
			}
			if(count == n) {  // 키가 몇번째인지 알 수 있음
				result++;	
			}
		}
		System.out.println(result);
	}
	
	// 플로이드-워셜을 사용해 모든 학생 간 연결이 가능한지 
	static void floyd(int[][] graph) {
	    for (int k = 1; k <= n; k++) { // 경유
	        for (int i = 1; i <= n; i++) { // 시작
	            for (int j = 1; j <= n; j++) { // 도착
	                // 경유 노드를 거쳐서 가는 것이 더 짧다면 갱신
	                if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
	                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
	                }
	            }
	        }
	    }
	}

}
