import java.io.*;
import java.util.*;
/*
1. 입력
행성의 개수 n, 발사되는 행성의 위치 k
...n줄 동안
이동시간 배열 n*n

2. 출력
모든 행성을 탐사하기 위한 최소 시간 출력

3. 풀이
모든 행성 - 모든 행성을 비교해야하므로 플로이드-워셜 알고리즘을 사용하여 비교한다.
	
*/
public class Main {
	static int n;
	static int [][] dist;
	static boolean [] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dist = new int[n][n];
		visited = new boolean[n];
		
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		floyd(dist);
		visited[k] = true;
		dfs(k, 0, 1);
		System.out.print(answer);
		
	}
	
	static void floyd(int[][] dist) {
		for(int i = 0; i<n; i++) {
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < n; l++) {
					dist[j][l] = Math.min(dist[j][l], dist[j][i] + dist[i][l]);
				}
			}
		}
	}
	
	static void dfs(int current, int cost, int count) {
		if(count == n) {
			answer = Math.min(answer, cost);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, cost + dist[current][i], count+1);
				visited[i] = false;
			}
		}
	}
	
}
