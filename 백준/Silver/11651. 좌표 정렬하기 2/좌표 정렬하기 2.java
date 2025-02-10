import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, (p1, p2) -> {
            if(p1[1] == p2[1]){
                return Integer.compare(p1[0], p2[0]);
            } else{
                return Integer.compare(p1[1], p2[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int[] point : points){
            sb.append(point[0]).append(" ").append(point[1]).append("\n");
        }
        System.out.println(sb);
    }
}


