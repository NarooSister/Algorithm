import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
방의 크기 N과 M
처음 로봇청소기의 좌표 (r, c), 바라보는 방향 d (0,1,2,3 - 북동남서)
N개의 줄 동안 각 장소의 상태를 나타내는 N*M의 칸 (0은 청소x, 1은 벽)

2. 출력
로봇청소기가 청소하는 칸의 개수 출력

3. 풀이


*/
public class Main {
    static int[] dx = {-1,0,1,0};   //북 동 남 서
    static int[] dy = {0,1,0,-1};
    static int[][] room;
    static boolean[][] cleaned;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());   
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 최초 방향

        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(robotClean(r,c,d));
    }
    static int robotClean(int x, int y, int d){
        int cleanCount = 0;
        cleaned = new boolean[n][m];
        while(true){

            // 1. 현재 칸이 아직 청소되지 않은 경우 -> 청소
            if(!cleaned[x][y]){
                cleaned[x][y] = true;
                cleanCount++;
            }
            // 2. 주변 칸 중 청소되지 않은 빈 칸이 있는 경우
            boolean cleanedAll = true;
            for (int i = 0; i < 4; i++) {
                int nd = (d+3) % 4;
                int nx = x + dx[nd];
                int ny = y + dy[nd];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !cleaned[nx][ny] && room[nx][ny] == 0){
                    x = nx;
                    y = ny;
                    d = nd;
                    cleanedAll = false;
                    break;
                }
                d = nd;
            }

            // 3. 주변 칸 중 청소되지 않은 빈 칸이 없는 경우
            if(cleanedAll) {
                int back = (d + 2) % 4;
                int bx = x + dx[back];
                int by = y + dy[back];

                if (bx >= 0 && by >= 0 && bx < n && by < m && room[bx][by] == 0) {
                    x = bx;
                    y = by;
                } else {
                    break;
                }
            }
        }
        return cleanCount;
    }
}