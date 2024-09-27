import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> set;
    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 입력
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i,j,"",0);
            }
        }
        System.out.println(set.size());
    }

    static void dfs(int x, int y, String num, int depth){
        if(depth == 6){
            set.add(num);
            return;
        }
        // 현재 위치 숫자 추가
        num += board[x][y];

        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&& nx<5 && ny>=0 && ny<5){
                dfs(nx,ny,num,depth+1);
            }
        }
    }
}

