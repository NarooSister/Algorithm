
import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		int from, to, weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Edge[] edges = new Edge[m];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u-1,v-1,weight);
		}
		
		bellmanFord(edges, n, 0);
	}
	
	static void bellmanFord(Edge[] edges, int n, int start) {
		long [] dist = new long[n];
		
		Arrays.fill(dist,  Long.MAX_VALUE);
		dist[start] = 0;
		
		boolean negative = false;
		for(int i = 0; i <n; i++) {
			for(Edge edge : edges) {
				if(dist[edge.from] != Long.MAX_VALUE && dist[edge.from] + edge.weight < dist[edge.to]) {
					dist[edge.to] = dist[edge.from] + edge.weight;
					if(i == n-1) {
						negative = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(negative) {
			sb.append("-1\n");
		} else {
			for(int i = 1; i < n; i++) {
				if(dist[i] == Long.MAX_VALUE) {
					sb.append("-1\n");
				} else {
				sb.append(dist[i]).append("\n");
				}
			}
		}	
		System.out.print(sb);
	}
}
