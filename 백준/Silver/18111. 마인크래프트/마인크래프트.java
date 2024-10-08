
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int [][] ground = new int[n][m];
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = 0;
		
		for(int i =0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j <m; j++) {
				int a = Integer.parseInt(st.nextToken());
				ground[i][j] = a;
				
				if(ground[i][j] < minHeight) {
					minHeight = ground[i][j];
				}
				if(ground[i][j] > maxHeight) {
					maxHeight = ground[i][j];
				}
			}
		}
		
		int resultTime = Integer.MAX_VALUE;
		int resultHeight = 0;
		
		for(int target = minHeight; target <= maxHeight; target++) {
			int remove = 0;
			int add = 0;
			
			for(int i=0; i<n; i++) {
				for(int j = 0; j < m; j++) {
					if(ground[i][j] > target) {
						remove += ground[i][j] - target;
					} else if(ground[i][j] < target) {
						add += target - ground[i][j];
					}
				}
			}
			
			if(remove + b >= add) {	// 돌이 충분하다면
				int time = remove*2 + add;
				
				if(time < resultTime || (time == resultTime && target > resultHeight)) {
					resultTime = time;
					resultHeight = target;
				}
			}
		}
		
		System.out.println(resultTime + " " + resultHeight);

	}
}
