import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
1. 입력
동굴의 크기 n (n=0인 입력이 주어질 때까지)
...n줄 동안
각 칸에 있는 도둑루피의 크기 배열 [][]

2. 출력
각 테스트케이스마다 Problem t: 최소 금액 
	
	
*/
public class Main {
		static int[] dx = {-1,1,0,0};
		static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		int testCase = 0;
		while((n =Integer.parseInt(br.readLine())) != 0) {
			testCase++;
			int [][] cave = new int [n][n];
			int [][] dist = new int [n][n];	// 최소비용 저장 배열
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int result = dijcstra(cave, dist, 0, n);
			System.out.println("Problem "+testCase+": "+result);
		}
	}
	
	static int dijcstra(int [][] cave, int[][] dist, int start, int n) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2] -b[2]);
		pq.offer(new int[]{0,0,cave[0][0]});
		dist[0][0] = cave[0][0];
		
		while(!pq.isEmpty()) {
			int [] current = pq.poll();
			int x = current[0];
			int y = current[1];
			int cost = current[2];
			
			if(cost > dist[x][y]) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					int nextCost = cost + cave[nx][ny];
					
					if(nextCost < dist[nx][ny]) {
						dist[nx][ny] = nextCost;
						pq.offer(new int[]{nx,ny,nextCost});
					}
				}
			}
		}
		
		return dist[n-1][n-1];
	}
}
