import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r,c;
    // 오른쪽, 아래, 왼쪽, 위
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 보드 입력
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i <r ; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                // 울타리가 있는 곳은 visited에 넣어서 이후 탐색하지 않도록 함
                if(board[i][j] == '#'){
                    visited[i][j] = true;
                }
            }
        }

        int liveSheep = 0;  // 산 양
        int liveWolves = 0; // 산 늑대
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 방문하지 않았고, 양이나 늑대가 있는 칸
                if(!visited[i][j] && (board[i][j] == 'k' || board[i][j] == 'v')){
                    int[] result = bfs(i,j);
                    int sheep = result[0];
                    int wolves = result[1];
                    // 개체수에 따른 살아남은 양, 늑대 조정
                    if(sheep > wolves){
                        liveSheep += sheep;
                    } else {
                        liveWolves += wolves;
                    }
                }
            }
        }
        System.out.println(liveSheep+" "+liveWolves);
    }

    static int[] bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int sheep = 0;
        int wolves = 0;
        // 초기 위치가 양이나 늑대인지 체크
        if(board[x][y]=='k') sheep++;
        if(board[x][y]=='v') wolves++;

        // 탐색 시작
        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            // queue에서 현재 위치 꺼내서 네 방향 탐색
            // 경계가 아닌 경우에 양, 늑대 수 탐색하고 기록
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                // 배열 경계 체크하고 방문 여부 확인
                if(nx>=0 && nx<r && ny>=0 && ny<c && !visited[nx][ny]){
                    visited[nx][ny] = true; // 방문 기록
                    queue.offer(new int[]{nx,ny});  // queue에 저장

                    if(board[nx][ny] == 'k') sheep++;
                    if(board[nx][ny] == 'v') wolves++;
                }
            }
        }
        // 탐색 결과 return;
        return new int[]{sheep, wolves};
    }
}

