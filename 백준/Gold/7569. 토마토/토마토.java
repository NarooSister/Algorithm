import java.io.*;
import java.util.*;


/*
1. 입력
상자의 크기 가로 M, 세로 N, 상자 높이 H
각 상자에 담긴 토마토의 정보(1-익음, 2-안익음, -1-토마토가 없음)
이런 상자가 H개 있다.

2. 출력
토마토가 모두 익는데까지 몇일이 걸리는지
만약 모든 토마토가 익어있는 상태면 0, 익지 못하는 상태라면 -1 출력

3. 문제 접근법


 */
public class Main {
    static int[][][] box;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int n, m, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[h][n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        int result = bfs(queue);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }

    static int bfs(Queue<int[]> queue) {
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];

                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (nz >= 0 && ny >= 0 && nx >= 0 && nz < h && ny < n && nx < m && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx});
                    }
                }
            }
            if (!queue.isEmpty()) days++;

        }
        return days;
    }
}


