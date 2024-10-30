
import java.io.*;
import java.util.*;

public class Main {
		public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [][] graph = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i==j){
				graph[i][j] = 0;
			} else {
				graph[i][j] = Integer.MAX_VALUE/2;
			}
		}
	}
		 // 친구 관계 입력
		 for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
	}

		for (int k = 1; k <= n; k++) {
				for (int i = 1; i <= n; i++) {
						for (int j = 1; j <= n; j++) {
							if (graph[i][j] > graph[i][k] + graph[k][j]) {
								graph[i][j] = graph[i][k] + graph[k][j];
						}
						}
				}
		}

		int answer = 1;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int num = 0;
			for (int j = 1; j <= n; j++) {
				num += graph[i][j];
			}
				if(num  < min){
					min = num;
					answer = i;
				}
			}
	
		System.out.println(answer);
	}
}
