import java.io.*;
import java.util.*;
/*
1. 입력
헛간의 개수 n, 길 개수 m
m줄 동안 a,b,c (a에서 b를 가는동안 만나는 소는 c마리)

2. 출력
농부가 가져가야 할 최소 여물

3. 풀이
다익스트라로 푼다.

	
*/
public class Main {
	static class Edge{
		int target, weight;
		Edge(int target, int weight){
			this.target = target;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<List<Edge>> graph = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		
		for(int i = 0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Edge(b,c));
			graph.get(b).add(new Edge(a,c));
		}
		
		System.out.println(dikjstra(graph, 1, n, n));

	}
	
	static int dikjstra(List<List<Edge>> graph, int start, int end, int n) {
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge current = pq.poll();
			int now = current.target;
			int cost = current.weight;
			
			if(cost > dist[now]) continue;
			
			for(Edge next : graph.get(now)) {
				int nextCost = cost + next.weight;
				
				if(nextCost < dist[next.target]) {
					dist[next.target] = nextCost;
					pq.offer(new Edge(next.target, nextCost));
				}
			}
		}
		return dist[end];
	}
}
