
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] miro;
	static int[][] miroCost;
	static boolean[][] visited;
	static boolean[][] done;
	static int result = 0;
	static Map<Character, int[]> dirMap = Map.of(
		'U', new int[]{-1, 0},
		'D', new int[]{1, 0},
		'L', new int[]{0, -1},
		'R', new int[]{0, 1}
	);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		miro = new char[n][m];
		miroCost = new int[n][m];
		visited = new boolean[n][m];
		done = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				miro[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				miroCost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!done[i][j]){
					dfs(i,j);
				}
			}
		}
		System.out.println(result);
	}

	static void dfs(int x, int y){
		// 탈출 가능하면 리턴
		if(x < 0 || x >= n || y < 0 || y >= m){
			return;
		}

		int[] dir = dirMap.get(miro[x][y]);
		int nx = x + dir[0];
		int ny = y + dir[1];

		if(done[x][y]){
			//사이클이 이미 완료된 경우 최소 비용 계산
			int cost = miroCost[x][y];
			int cx = x, cy = y;
			do {
				cost = Math.min(cost, miroCost[cx][cy]);
				int[] nextDir = dirMap.get(miro[cx][cy]);
				cx += nextDir[0];
				cy += nextDir[1];
			} while(!(cx == x && cy ==y));
			result += cost;
			return;
		}
	
		if(visited[x][y]) return;

		visited[x][y] = true;
		done[x][y] = true;
		dfs(nx, ny);
		done[x][y] = false;
	}
}
