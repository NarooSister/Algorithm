import java.io.*;
import java.util.*;
/*
1. 입력
회원의 수 n
두 회원이 친구인지
...
마지막 줄 -1,-1

2. 출력
회장 후보의 점수, 후보의 수
회장 후보를 오름차순으로 모두 출력

3. 풀이
모든 회원의 사이를 구해야하므로 플로이드-워셜을 쓴다.

	
*/
public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		n = Integer.parseInt(br.readLine());
		int [][] graph = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE); // 각 행을 초기화
			graph[i][i] = 0;	// 자기 자신은 0
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1) break;
			
			graph[a][b] = graph[b][a] = 1;	// 친구 사이는 1
		}
		
		// 모든 회원간의 최단경로 계산
		floyd(graph);
		
		int [] scores = new int[n+1];
		int minScore = Integer.MAX_VALUE;
		
		for(int i=1; i<=n; i++) {
			int maxDist = 0; // 친구 사이 최장거리
			for(int j = 1; j <=n; j++) {
				if(graph[i][j] !=Integer.MAX_VALUE) {
					maxDist = Math.max(maxDist, graph[i][j]);
				}
			}
			scores[i] = maxDist;
			minScore = Math.min(minScore, maxDist);
		}
		
		List<Integer> leader = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			if(scores[i] == minScore) {
				leader.add(i);
			}
		}
		
		System.out.println(minScore +" "+ leader.size());
		for(int a : leader) {
			System.out.print(a+" ");
		}
	}
	
	// 플로이드-워셜을 사용해 모든 회원간의 최단경로 계산(친구 사이인지, 친구친구...인지)
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
