
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] item = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dist[a][b] = c;
			dist[b][a] = c;
		}

		floyd(n, dist);

		int maxItems = 0;
		for (int i = 1; i <= n; i++) {
			int current = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] <= m) {
					current += item[j];
				}
			}
			maxItems = Math.max(current, maxItems);
		}

		System.out.print(maxItems);
	}

	static void floyd(int n, int[][] dist) {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
	}
}
