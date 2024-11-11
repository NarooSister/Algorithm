import java.io.*;
import java.util.*;
/*
1. 입력
한 줄에 들어가는 방의 수 n

2. 출력
흰 방으로 바꾸어야 할 최소 검은 방 수

3. 풀이
가중치가 0과 1로 이루어져 있으므로 0-1 bfs를 사용해서 푼다.

	
*/
public class Main {
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static class Node{
		int x, y, cost;
		
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] rooms = new int[n][n];
		int [][] dist = new int[n][n];

		for(int i = 0; i< n; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				rooms[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(bfs(rooms, dist, n));

	}
	
	static int bfs(int[][] rooms, int [][] dist, int n) {
		Deque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(0,0,0));
		dist[0][0] = 0;
		
		while(!deque.isEmpty()) {
			Node current = deque.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					int nextCost = current.cost + (rooms[nx][ny] == 0 ? 1 : 0);
					if(nextCost < dist[nx][ny]) {
						dist[nx][ny] = nextCost;

						if(rooms[nx][ny]==1) {	// 흰방이면 큐 앞에 추가
							deque.addFirst(new Node(nx, ny, dist[nx][ny]));
						} else {	// 검은 방이면 큐 뒤에 추가
							deque.addLast(new Node(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
		}
		return dist[n-1][n-1];
	}
}
