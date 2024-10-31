
import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int u, v, weight;

		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			List<Edge> graph = new ArrayList<>();

			for (int j = 0; j < m + w; j++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				if (j < m) {
					graph.add(new Edge(s, e, t));
					graph.add(new Edge(e, s, t));
				} else {
					graph.add(new Edge(s, e, -t));

				}
			}
			
			boolean isNegative = false;
			for (int j = 1; j <= n; j++) {
				if(bellmanFord(graph, n, j)){
					System.out.println("YES");
					isNegative = true;
					break;
				}
			}
			if(!isNegative){
				System.out.println("NO");
			}
		}
	}

	public static boolean bellmanFord(List<Edge> graph, int n, int start) {
		int INF = 1000000000;
		int[] dist = new int[n + 1];
		boolean update = false;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		for (int i = 1; i < n; i++) {
			update = false;
			for (Edge edge : graph) {
				if (dist[edge.u] != INF && dist[edge.u] + edge.weight < dist[edge.v]) {
					dist[edge.v] = dist[edge.u] + edge.weight;
					update = true;
				}
			}

			if (!update) {
				break;
			}
		}

		for (Edge edge : graph) {
			if (dist[edge.u] != INF && dist[edge.u] + edge.weight < dist[edge.v]) {
				return true;
			}
		}
		return false;
	}
}
