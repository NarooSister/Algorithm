import java.io.*;
import java.util.*;

/*
1. 입력
화성 지형 크기 n,m
n*m 지형의 정보

2. 출력
최대 가치의 합 출력

3. 풀이
위로 갈 수 없으므로 왼쪽, 오른쪽, 아래로만 간다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] mars = new int[n + 2][m + 2];
        int[][] save = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        save[1][1] = mars[1][1];
        for (int i = 2; i <=m ; i++) {
            save[1][i] = save[1][i-1]+mars[1][i];
        }
        // 왼쪽에서 오른쪽으로 갈때, 반대로 갈 때 각각 최댓값을 구해서 저장
        for (int i = 2; i <= n; i++) {
            int [] toRight = new int[m+1];
            int [] toLeft = new int[m+1];

            toRight[1] = save[i-1][1]+ mars[i][1];
            for (int j = 2; j <= m; j++) {
                toRight[j] = Math.max(save[i-1][j], toRight[j-1]) + mars[i][j];
            }

            toLeft[m] = save[i-1][m] + mars[i][m];
            for (int j = m-1; j >= 1 ; j--) {
                toLeft[j] = Math.max(save[i-1][j], toLeft[j+1]) + mars[i][j];
            }

            for (int j = 1; j <=m ; j++) {
                save[i][j] = Math.max(toRight[j], toLeft[j]);
            }

        }
        System.out.println(save[n][m]);
    }
}
